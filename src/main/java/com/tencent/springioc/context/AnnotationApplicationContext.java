package com.tencent.springioc.context;

import com.tencent.springioc.annotation.Resource;
import com.tencent.springioc.annotation.Service;
import com.tencent.springioc.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationApplicationContext {
    //扫包范围
    private String packageName;
    ConcurrentHashMap<String, Object> IOCMap = null;

    public AnnotationApplicationContext(String packageName) throws Exception{
        this.packageName = packageName;
        //1.初始化IOC容器
        initIOCMap();
    }

    /**
     * 根据beanId查找对应的对象
     * 1.通过beanID查找查找对应bean对象
     * 2.使用反射将加有自定义注解Resource的类作为属性注入到该对象中
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) throws Exception {
        //1.通过beanID查找查找对应bean对象
        Object obj = IOCMap.get(beanId);
        //2.使用反射将加有自定义注解Resource的类作为属性注入到该对象中
        attriAssign(obj);
        return obj;
    }

    /**
     * 使用反射将加有自定义注解Resource的类作为属性注入到该对象中
     * @param obj
     * @return
     */
    private void attriAssign(Object obj) throws Exception {
        Class<?> classInfo = obj.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();
        for(Field field:declaredFields){
            //如果存在自定义Resource注解
            if(field.getDeclaredAnnotation(Resource.class) == null){
                continue;
            }
            //属性名称
            String beanId = field.getName();
            //使用属性名称查找bean容器
            Object bean = getBean(beanId);
            if(bean == null){
                continue;
            }
            //私有访问允许访问
            field.setAccessible(true);
            //给属性赋值
            //将加有自定义注解Resource的类作为属性注入到该对象中
            field.set(obj,bean);
        }
    }

    /**
     * 初始化IOC容器
     * 1.初始化IOC容器
     * 2.使用反射机制获取该包下所有已存在自定义Service注解的类
     * 3.使用Java反射机制初始化对象
     * 4.使用反射将加有自定义注解Resource的类作为属性注入到该对象中
     */
    private void initIOCMap() throws Exception {
        //1.初始化IOC容器
        IOCMap = new ConcurrentHashMap<String, Object>();
        //2.使用反射机制获取该包下所有已存在自定义Service注解的类
        List<Class> classSericeDemo = findClassSericeDemo();
        //3.使用Java反射机制初始化对象
        InitBean(classSericeDemo);
    }

    /**
     * 1.利用反射机制，获取包下所有的类
     * 2.遍历获取到的类的集合，判断该类上属否存在自定义service注解
     * 3.获得存在自定义service注解的类的集合
     */
    private List<Class> findClassSericeDemo(){
        List<Class> exisClassesAnnotation = new ArrayList<Class>();
        if(packageName == null && "".equals(packageName)){
            return null;
        }
        //1.利用反射机制，获取包下所有的类
        List<Class<?>> classesByPackageName = ClassUtil.getClasses(packageName);
        for(Class classInfo:classesByPackageName){
            //2.判断该类上属否存在注解
            Service serviceDemo = (Service) classInfo.getDeclaredAnnotation(Service.class);
            if(serviceDemo == null){
                continue;
            }
            //3.获得存在自定义service注解的类的集合
            exisClassesAnnotation.add(classInfo);
        }
        return exisClassesAnnotation;
    }

    /**
     * 初始化bean
     * 1.初始化对象
     * 2.获得类的简写名称
     * 3.加载到IOC容器中
     * @param classSericeDemo
     * @throws Exception
     */
    private void InitBean(List<Class> classSericeDemo) throws Exception{
        for(Class classInfo:classSericeDemo){
            //1.初始化对象
            Object obj = classInfo.newInstance();
            //2.获得类的简写名称
            String beanId = ClassUtil.toLowerCaseFirstOne(classInfo.getSimpleName());
            //3.加载到IOC容器中
            IOCMap.put(beanId,obj);
        }
    }

}
