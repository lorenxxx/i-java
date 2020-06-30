package com.us.improve.functionalinterface;

import java.util.function.Consumer;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/29 10:29 PM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {

        int num = 10;

        Consumer<String> consumer = ele -> {
            System.out.println(num);
        };

        //num = num + 2;
        consumer.accept("hello");
    }

}
