package com.us.improve.sort;

/**
 * @ClassName SelectionSort
 * @Desciption 选择排序
 * @Author Loren
 * @Date 2018/11/29 11:15
 * @Version 1.0
 **/
public class SelectionSort {

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

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[i] = arr[i] + arr[minIndex];
                arr[minIndex] = arr[i] - arr[minIndex];
                arr[i] = arr[i] - arr[minIndex];
            }
        }
    }

}
