package com.test.aop.test;



/**
 * @author: liuxl
 * @date: 2018-06-04 15:54
 * @description:
 */

public class Test1 {

    public void test1(String param){
        System.out.println("test1" + param);
        test2(param);
    }
    private void test2(String param){
        System.out.println("test2" + param);
    }
}