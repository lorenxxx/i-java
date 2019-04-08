package com.us.improve.datastructure.sort;

/**
 * @ClassName InsertionSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 3:55 PM
 * @Version 1.0
 **/
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }

    }

}
