package com.us.improve.sort;

/**
 * @ClassName SortSupportDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/5/22 3:20 PM
 * @Version 1.0
 **/
public class SortSupportDemo {

    public static void main(String[] args) {
        int[] source = new int[] {9, 8, 3, 5, 2, 10, 1, 7, 4, 6};

        Sort sort = new SortSupport();

        int[] target1 = new int[source.length];
        System.arraycopy(source, 0, target1, 0, source.length);
        sort.insertSort(target1);
        display(target1);
    }

    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
