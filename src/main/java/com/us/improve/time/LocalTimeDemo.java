package com.us.improve.time;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @ClassName LocalTimeDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/7/20 19:01
 * @Version 1.0
 **/
public class LocalTimeDemo {

    public static void main(String[] args) {
        // 获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // 设置时间
        LocalTime localTime = LocalTime.of(19, 21, 20);
        System.out.println(localTime);

        // 获取小时
        int hour1 = localTime.getHour();
        System.out.println(hour1);
        int hour2 = localTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println(hour2);

        // 获取分
        int minute1 = localTime.getMinute();
        System.out.println(minute1);
        int minute2 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println(minute2);
        int minute3 = localTime.get(ChronoField.MINUTE_OF_DAY);
        System.out.println(minute3);

        // 获取秒
        int second1 = localTime.getSecond();
        System.out.println(second1);
        int second2 = localTime.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println(second2);
        int second3 = localTime.get(ChronoField.SECOND_OF_DAY);
        System.out.println(second3);
    }

}
