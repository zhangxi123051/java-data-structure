package com.tencent.springioc.test;

import com.tencent.springioc.context.AnnotationApplicationContext;
import com.tencent.springioc.context.ClassPathXmlApplicationContext;
import com.tencent.springioc.service.UserServiceImpl;

public class Test {

    public void testXml() throws Exception {
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("/Users/hot/dev/java_workspace/java-data-structure/src/resources/bean.xml");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("userServiceImpl");
        userService.add();
    }

    public void testAnnotation() throws Exception {
        AnnotationApplicationContext app = new AnnotationApplicationContext("com.tencent.springioc.service");
        UserServiceImpl userService = (UserServiceImpl) app.getBean("userServiceImpl");
        userService.add();
    }

    public static void main(String[] args) throws Exception {
        new Test().testXml();
    }
}

