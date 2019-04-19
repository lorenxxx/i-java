package com.us.improve.datastructure.sort;

/**
 * @ClassName ShellSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 4:50 PM
 * @Version 1.0
 **/
public class ShellSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int value = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > value) {
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = value;
            }
            gap = gap / 2;
        }
    }

}
