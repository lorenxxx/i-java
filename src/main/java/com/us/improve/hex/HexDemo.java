package com.us.improve.hex;

/**
 * @ClassName HexDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/29 11:55 AM
 * @Version 1.0
 **/
public class HexDemo {

    public static void main(String[] args) {
        int from = 0x0000;
        int to = 0xffff;
        //System.out.println(Integer.toHexString(from));
        System.out.println(to);
        System.out.println(Integer.toHexString(to));

        int sensorId = 1000;
        System.out.println(Integer.toHexString(sensorId));

        int increaseSensorId = 1001;
        System.out.println(Integer.toHexString(increaseSensorId));
    }

}
