package com.test.main;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author: liuxl
 * @date: 2018-06-06 10:29
 * @description:
 */
public class StartUp {

    @Autowired
    private static BeanClass beanClass;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        reader.loadBeanDefinitions(new ClassPathResource("spring.xml"));

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("----");
        System.out.println(beanClass);
        beanClass = (BeanClass) factory.getBean("beanClass");
        System.out.println(beanClass);
        System.out.println("启动用时:" + (System.currentTimeMillis() - start) + "毫秒");

    }
    @Test
    public void test1(){
//        System.out.println(RequestMethod.POST);
    }
}