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

        int[] target1 = copyArray(source);
        sort.insertSort(target1);
        display(target1);

        int[] target2 = copyArray(source);
        sort.shellSort(target2);
        display(target2);
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        if (arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        return result;
    }

    private static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
