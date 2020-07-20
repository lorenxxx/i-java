package com.us.improve.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @ClassName LocalDateDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/7/20 19:00
 * @Version 1.0
 **/
public class LocalDateDemo {

    public static void main(String[] args) {
        // 获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 设置日期
        LocalDate localDate = LocalDate.of(2020, 8, 10);
        System.out.println(localDate);

        // 获取年
        int year1 = localDate.getYear();
        System.out.println(year1);
        int year2 = localDate.get(ChronoField.YEAR);
        System.out.println(year2);

        // 获取月
        Month month1 = localDate.getMonth();
        System.out.println(month1);
        int month2 = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month2);

        // 获取日
        int day1 = localDate.getDayOfMonth();
        System.out.println(day1);
        int day2 = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println(day2);
        int day3 = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day3);
        int day4 = localDate.get(ChronoField.DAY_OF_YEAR);
        System.out.println(day4);
    }

}
