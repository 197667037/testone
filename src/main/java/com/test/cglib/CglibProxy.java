package com.test.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: liuxl
 * @date: 2018-05-31 14:45
 * @description:
 */
public class CglibProxy implements MethodInterceptor {

    private Object obj;

    public <T> T getInstance(T object){
        obj = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);

        return (T)enhancer.create();

    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("结束...");
        return null;
    }
}