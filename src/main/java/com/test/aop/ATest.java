package com.test.aop;

import com.test.aop.test.Test1;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: liuxl
 * @date: 2018-06-04 15:57
 * @description:
 */
public class ATest {
    static ClassPathXmlApplicationContext context;
    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void test1(){
        Test1 bean = context.getBean(Test1.class);
        AopTest bean1 = context.getBean(AopTest.class);
        System.out.println(bean1);
        bean.test1("111111");
    }
}