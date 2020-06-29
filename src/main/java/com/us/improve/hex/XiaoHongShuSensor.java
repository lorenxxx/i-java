package com.us.improve.hex;

/**
 * @ClassName XiaoHongShuSensor
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/29 3:02 PM
 * @Version 1.0
 **/
public class XiaoHongShuSensor {

    public static void main(String[] args) {
        int beijingSensorIdBegin = 1000;
        int beijingSensorIdEnd = 1999;
        System.out.println(Integer.toHexString(beijingSensorIdBegin) + " ~ " + Integer.toHexString(beijingSensorIdEnd));

        int shanghaiSensorIdBegin = 2000;
        int shanghaiSensorIdEnd = 2999;
        System.out.println(Integer.toHexString(shanghaiSensorIdBegin) + " ~ " + Integer.toHexString(shanghaiSensorIdEnd));

        int wuhanSensorIdBegin = 3000;
        int wuhanSensorIdEnd = 3999;
        System.out.println(Integer.toHexString(wuhanSensorIdBegin) + " ~ " + Integer.toHexString(wuhanSensorIdEnd));

        //String hexStr = Integer.toHexString(wuhanSensorIdBegin);
        String hexStr = "bb8";
        Integer num = Integer.parseInt(hexStr, 16);
        System.out.println(num);
    }

}
