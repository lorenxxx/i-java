package com.us.improve.array;

/**
 * @ClassName Demo3
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/14 15:43
 * @Version 1.0
 **/
public class Demo3 {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 10, 3, 4, 9, 14, 20};

        int[] tmp = new int[21];
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i]]++;
        }

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < tmp[i]; j ++) {
                System.out.println(i);
            }
        }
    }

}
