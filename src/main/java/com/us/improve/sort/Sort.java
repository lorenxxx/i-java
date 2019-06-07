package com.us.improve.sort;

/**
 * @ClassName Sort
 * @Desciption 排序接口
 * @Author loren
 * @Date 2019/5/22 2:54 PM
 * @Version 1.0
 **/
public interface Sort {

    /**
     * 插入排序
     *
     * @param array 待排序数组
     */
    void insertSort(int[] array);

    /**
     * 希尔排序
     *
     * @param array 待排序数组
     */
    void shellSort(int[] array);

    /**
     * 选择排序
     *
     * @param array 待排序数组
     */
    void selectSort(int[] array);

    /**
     * 堆排序
     *
     * @param array 待排序数组
     */
    void heapSort(int[] array);

    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     */
    void bubbleSort(int[] array);

    /**
     * 快速排序
     *
     * @param array 待排序数组
     */
    void quickSort(int[] array);

    /**
     * 归并排序
     *
     * @param array 待排序数组
     */
    void mergeSort(int[] array);

    /**
     * 基数排序
     *
     * @param array 待排序数组
     */
    void radixSort(int[] array);

    default void checkEmpty(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array is empty.");
        }
    }

}