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
     * @param arr 待排序数组
     */
    void insertSort(int[] arr);

    /**
     * 希尔排序
     *
     * @param arr 待排序数组
     */
    void shellSort(int[] arr);

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    void selectSort(int[] arr);

    /**
     * 堆排序
     *
     * @param arr 待排序数组
     */
    void heapSort(int[] arr);

    /**
     * 冒泡排序
     *
     * @param arr 待排序数组
     */
    void bubbleSort(int[] arr);

    /**
     * 快速排序
     *
     * @param arr 待排序数组
     */
    void quickSort(int[] arr);

    /**
     * 归并排序
     *
     * @param arr 待排序数组
     */
    void mergeSort(int[] arr);

    /**
     * 基数排序
     *
     * @param arr 待排序数组
     */
    void radixSort(int[] arr);

    default void checkEmpty(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is empty.");
        }
    }

}