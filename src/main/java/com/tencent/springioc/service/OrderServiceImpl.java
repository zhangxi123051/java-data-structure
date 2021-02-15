package com.tencent.springioc.service;

import com.tencent.springioc.annotation.Service;
import org.omg.CORBA.PUBLIC_MEMBER;

@Service
public class OrderServiceImpl{

    public OrderServiceImpl(){
        System.out.println("init OrderServiceImpl");
    }
    public void addOrder() {
        System.out.println("addOrder");
    }
}
