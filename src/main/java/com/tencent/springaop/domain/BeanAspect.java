package com.tencent.springaop.domain;


import com.tencent.springaop.annotion.Aspect;
import com.tencent.springaop.annotion.PointCut;
import com.tencent.springaop.proxy.AbsMethodAdvance;

@Aspect
public class BeanAspect extends AbsMethodAdvance {
    /**
     *全类名 方法名
     */
    @PointCut("com.tencent.springaop.domain.Bean_doSomeThing")
    public void testAspect(){

    }


    @Override
    public void doBefore() {
        System.out.println("do before");
    }

    @Override
    public void doAfter() {
        System.out.println("do after");
    }
}
