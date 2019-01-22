package com.test.main;

import org.springframework.stereotype.Component;

/**
 * @author: liuxl
 * @date: 2018-06-06 10:34
 * @description:
 */
@Component
public class BeanClass {

    public BeanClass() {
        System.err.println("BeanClass实例化");
    }
}