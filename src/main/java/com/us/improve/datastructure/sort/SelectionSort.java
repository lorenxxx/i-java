package com.us.improve.datastructure.sort;

/**
 * @ClassName SelectionSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 4:02 PM
 * @Version 1.0
 **/
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (i != min) {
                swap(array, i, min);
            }
        }
    }

}
