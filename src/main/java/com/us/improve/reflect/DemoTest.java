package com.us.improve.reflect;

import java.io.Serializable;

/**
 * @author liangliang
 * @date 2018/11/20 11:30 PM
 */
public class DemoTest implements Serializable {

    private static final long serialVersionUID = 1L;

    public DemoTest() {
    }

    public DemoTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello(String someone) {
        System.out.println("hello " + someone);
    }
}