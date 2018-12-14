package com.us.improve.array;

/**
 * @ClassName RingArrayDemo
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/14 16:07
 * @Version 1.0
 **/
public class RingArrayDemo {

    public static void main(String[] args) {
        RingArray ringArray = new RingArray(10);

        ringArray.set(0, 20);
        System.out.println(ringArray.get(0));

        System.out.println(ringArray.get(20));
    }

}
