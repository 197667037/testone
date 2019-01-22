package com.test.test1;

import com.test.model.Person;
import com.test.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuxl
 * @date: 2018-04-02 17:16
 * @description:
 */
public class Test2 {

    @org.junit.Test
    public void test1(){
        String[] names = {"1","3","2"};
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("4");
        list.add("3");
        list.add("2");
        list.forEach(s -> System.out.println(s));

    }

}



interface One<T>{
    public void test1(T t);
}

interface Two<S extends Person> extends One<Person> {

}

class Three implements Two<Student>{

    public void test1(Person person) {

    }
}


class A {
    int a = 0 ;
    int b = 1 ;
}

class B extends A{
    int c = 1;
    double d = 2.2;
}

class C {
    public int  CCC(A a){
        System.out.println();
        return 1;
    }
}

class Test{
    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        c.CCC(b);

    }
}
