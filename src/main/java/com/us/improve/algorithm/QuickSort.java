package com.us.improve.algorithm;

/**
 * @ClassName QuickSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/1 11:13 AM
 * @Version 1.0
 **/
public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;

        int pivot = arr[low];

        while (i < j) {
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            while (pivot <= arr[j] && i < j) {
                j--;
            }

            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            arr[low] = arr[i];
            arr[i] = pivot;

            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }

}
