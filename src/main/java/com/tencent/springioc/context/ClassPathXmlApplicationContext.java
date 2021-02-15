package com.tencent.springioc.context;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//通过XML方式注入bean
public class ClassPathXmlApplicationContext {
    private String xmlPath;
    ConcurrentHashMap<String, Object> IOCMap = null;

    public ClassPathXmlApplicationContext(String xmlPath) throws Exception{
        this.xmlPath = xmlPath;
        //1.初始化IOC容器
        initIOCMap();
    }

    //2.根据beanId查找对应的对象
    public Object getBean(String beanId){
        return IOCMap.get(beanId);
    }


    /**
     * 初始化IOC容器
     * 1.初始化IOC容器
     * 2.读取XML配置，获取节点
     * 3.遍历节点，获取bean信息（beanId,classPath）
     * 4.通过反射机制，在IOC容器中初始化对象
     */
    private void initIOCMap() throws Exception {
        //1.初始化IOC容器
        IOCMap = new ConcurrentHashMap<String, Object>();
        //2.读取XML配置，获取节点
        List<Element> elements = readXML();
        //3.遍历节点，获取bean信息（beanId,classPath）
        List<Map<String,String>> beanDetails = getBeanDetail(elements);
        //4.通过反射机制，在IOC容器中初始化对象
        newInstances(beanDetails);
    }

    //读取XML配置，获取节点
    private List<Element> readXML() throws DocumentException {
        //1.判断xml路径是否为空
        if(xmlPath == null || "".equals(xmlPath)){
            return null;
        }
        System.out.println("xmlPath="+xmlPath);
        //2.读取配置文件
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(resourceAsStream);
        //3.读取根节点
        Element rootElement = read.getRootElement();
        //4.读取子节点
        List<Element> elements = rootElement.elements();
        return elements;
    }

    //遍历节点，获取bean信息（beanId,classPath）
    private List<Map<String,String>> getBeanDetail(List<Element> elements){
        List<Map<String,String>> beanDetails = new ArrayList<Map<String, String>>();
        for(Element element:elements){
            Map<String,String> beanDetail = new HashMap<String, String>();
            //1.拿到beanId的名称
            String beanIdValue = element.attributeValue("id");
            if(beanIdValue == null || "".equals(beanIdValue)){
                continue;
            }
            //2.拿到class路径地址
            String classPath = element.attributeValue("class");
            if(classPath == null || "".equals(classPath)){
                continue;
            }
            beanDetail.put("beanId",beanIdValue);
            beanDetail.put("classPath",classPath);
            beanDetails.add(beanDetail);
        }
        return beanDetails;
    }

    //通过反射机制，在IOC容器中初始化对象
    private void newInstances(List<Map<String,String>> beanDetails) throws Exception {
        for(Map<String,String> beanDetail:beanDetails){
            String classPath = beanDetail.get("classPath");
            String beanId = beanDetail.get("beanId");
            //利用反射机制，初始化对象
            Object obj = newInstance(classPath);
            //将初始化对象放到IOC容器中
            IOCMap.put(beanId,obj);
        }
    }

    //利用反射机制，初始化对象
    private Object newInstance(String classPath)throws Exception{
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
