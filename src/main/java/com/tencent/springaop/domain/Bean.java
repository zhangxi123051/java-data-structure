package com.tencent.springaop.domain;

public class Bean {
    public void doSomeThing(){
        System.out.println("do some thing...");
    }

    public void doWithNotProxy(){
        System.out.println("do some thing with not proxy");
    }
}
