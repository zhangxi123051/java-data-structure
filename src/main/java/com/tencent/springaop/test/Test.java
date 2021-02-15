package com.tencent.springaop.test;

import com.tencent.springaop.context.ApplicationContext;
import com.tencent.springaop.domain.Bean;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args){
        //模拟容器初始化
        ApplicationContext applicationContext = new ApplicationContext();
        ConcurrentHashMap<String,Object> proxyBeanMap = ApplicationContext.proxyBeanMap;
        System.out.println(proxyBeanMap.toString());
        //生成代理对象，默认为该类名的小写
        Bean demo =(Bean)proxyBeanMap.get("bean");

        demo.doSomeThing();
        System.out.println("------------");
        demo.doWithNotProxy();
    }

}
