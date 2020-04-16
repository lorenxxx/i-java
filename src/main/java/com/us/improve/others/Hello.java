package com.us.improve.others;

/**
 * @ClassName Hello
 * @Desciption TODO
 * @Author loren
 * @Date 2019/7/10 12:08 AM
 * @Version 1.0
 **/
public class Hello {

    public Hello(Object obj) {
        System.out.println("Object");
    }

    public Hello(String[] strs) {
        System.out.println("Array");
    }

    public static void main(String[] args) {
        new Hello(null);
    }

}
