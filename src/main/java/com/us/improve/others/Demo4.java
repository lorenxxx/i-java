package com.us.improve.others;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName Demo4
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/18 3:09 PM
 * @Version 1.0
 **/
public class Demo4 {

    public static void main(String[] args) {
        String uuidPart = UUID.randomUUID().toString().substring(0, 13);
        DateFormat df = new SimpleDateFormat("ddHHmmss");
        String dayTime = df.format(new Date());
        String result = String.format("%s-%s-D%s", "Bind_Car".toUpperCase(), uuidPart.toUpperCase(), dayTime);
        System.out.println(result);
    }

}
