package com.us.improve.sort;

/**
 * @ClassName BubbleSort
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/11/27 16:58
 * @Version 1.0
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 8, 3, 5, 2};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }

}
