package com.us.improve.sort;

/**
 * @ClassName SortSupport
 * @Desciption TODO
 * @Author loren
 * @Date 2019/5/22 3:06 PM
 * @Version 1.0
 **/
public class SortSupport implements Sort {

    @Override
    public void insertSort(int[] array) {
        checkEmpty(array);

        int length = array.length;
        for (int i = 1; i < length; i++) {
            int insertValue = array[i];
            int j = i - 1;

            /**
             for (; j >= 0 && arr[j] > insertValue; j--) {
             arr[j + 1] = arr[j];
             }
             */

            while (j >= 0 && array[j] > insertValue) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertValue;
        }
    }

    @Override
    public void shellSort(int[] arr) {
        checkEmpty(arr);

        int length = arr.length;
        int gap = length;
        while (gap != 0) {
            gap = gap / 2;
            for (int t = 0; t < gap; t++) {
                for (int i = t + gap; i < length; i = i + gap) {
                    int insertValue = arr[i];
                    int j = i - gap;

                    while (j >= 0 && arr[j] > insertValue) {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = insertValue;
                }
            }
        }
    }

    @Override
    public void selectSort(int[] array) {
        checkEmpty(array);

        int length = array.length;
        for (int i = 0; i < length; i++) {
            int position = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[position]) {
                    position = j;
                }
            }

            if (i != position) {
                int temp = array[i];
                array[i] = array[position];
                array[position] = temp;
            }
        }
    }

    @Override
    public void heapSort(int[] array) {

    }

    @Override
    public void bubbleSort(int[] array) {

    }

    @Override
    public void quickSort(int[] array) {

    }

    @Override
    public void mergeSort(int[] array) {

    }

    @Override
    public void radixSort(int[] array) {

    }

}
