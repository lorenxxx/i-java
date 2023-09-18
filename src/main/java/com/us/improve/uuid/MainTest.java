package com.us.improve.uuid;

import java.util.UUID;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/9 12:35 AM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            GenUUID();
        }
    }

    public static void GenUUID() {
        System.out.println(UUID.randomUUID());
    }

}
