package com.test.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author: liuxl
 * @date: 2018-03-29 17:43
 * @description:
 */
public class Student extends Person{

    public String name;

    public Integer age;
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
