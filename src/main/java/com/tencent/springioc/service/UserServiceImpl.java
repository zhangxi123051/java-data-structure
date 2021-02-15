package com.tencent.springioc.service;


import com.tencent.springioc.annotation.Resource;
import com.tencent.springioc.annotation.Service;

//将该类注入到spring容器里面
@Service
public class UserServiceImpl {


    public UserServiceImpl(){
        System.out.println("init UserServiceImpl");
    }

    // 从Spring容器中读取bean
    @Resource
    private OrderServiceImpl orderServiceImpl;

    public void add() {
        orderServiceImpl.addOrder();
        System.out.println("我是使用反射机制运行的方法");
    }
}





