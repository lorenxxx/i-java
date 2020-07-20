package com.us.improve.time;

import java.time.Instant;

/**
 * @ClassName InstantDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/7/20 19:26
 * @Version 1.0
 **/
public class InstantDemo {

    public static void main(String[] args) {
        // 创建Instant对象
        Instant instant = Instant.now();

        // 获取秒
        long currentSecond = instant.getEpochSecond();
        System.out.println(currentSecond);

        // 获取毫秒
        long currentMilli = instant.toEpochMilli();
        System.out.println(currentMilli);
    }

}
