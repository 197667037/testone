package com.test.cglib;

/**
 * @author: liuxl
 * @date: 2018-05-31 14:44
 * @description:
 */
public class CGlibTest {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        CarNoInterface instance = proxy.getInstance(new CarNoInterface());
        instance.run();
    }
}