package com.us.improve.datastructure.sort.repeat;

import com.us.improve.datastructure.sort.Sort;

/**
 * @ClassName BubbleSort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/9 11:06 AM
 * @Version 1.0
 **/
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
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

    public static void main(String[] args) {
        int[] array = new int[] {1, 10, 5, 7, 9, 6, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.display(array);
    }

}
