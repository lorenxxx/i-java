package com.us.improve.others;

/**
 * @ClassName Demo3
 * @Desciption System.arraycopy
 * @Author loren
 * @Date 2019/3/26 7:46 PM
 * @Version 1.0
 **/
public class Demo3 {


    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 4, 5};
        int[] array2 = new int[10];

        System.arraycopy(array1, 0, array2, 5, array1.length);

        for (int i : array2) {
            System.out.println(i);
        }
    }




}
