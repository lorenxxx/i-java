package com.us.improve.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/7/20 19:01
 * @Version 1.0
 **/
public class DateDemo {

    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(date);

        System.out.println(dateStr);
    }

}
