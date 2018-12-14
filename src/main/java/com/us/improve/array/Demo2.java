package com.us.improve.array;

/**
 * @ClassName Demo2
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/14 15:10
 * @Version 1.0
 **/
public class Demo2 {

    public static void main(String[] args) {
        String upperCase = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghigklmnopqrstuvwxyz";

        char[] upperArray = upperCase.toCharArray();
        for (char c : upperArray) {
            System.out.println((int) c);
        }

        System.out.println("----------------------");

        char[] lowArray = lowerCase.toCharArray();
        for (char c : lowArray) {
            System.out.println((int) c);
        }

        String word = "whereareyou";
        int[] times = new int[123];

        char[] wordArray = word.toCharArray();
        for (char c : wordArray) {
            times[c]++;
        }

        for (int time : times) {
            System.out.println(time);
        }

    }

}
