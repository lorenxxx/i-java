package com.us.improve.datastructure.sort;

/**
 * @ClassName Sort
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 2:26 PM
 * @Version 1.0
 **/
public interface Sort {

    void sort(int[] array);

    default void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    default void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}