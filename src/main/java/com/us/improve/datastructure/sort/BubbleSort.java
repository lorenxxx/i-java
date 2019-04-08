package com.us.improve.datastructure.sort;

/**
 * @ClassName BubbleSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 2:25 PM
 * @Version 1.0
 **/
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }

}
