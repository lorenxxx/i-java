package com.us.improve.string;

/**
 * Created by Loren on 2018/11/16.
 */
public class MainTest {

    private static final String TEMPLATE = "hello %s";

    public static void main(String[] args) {
        String replace = String.format(TEMPLATE, "world");
        System.out.println(replace);
    }

}
