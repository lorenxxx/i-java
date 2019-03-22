package com.us.improve.algorithm;

/**
 * @ClassName mergeSortedArray
 * @Desciption TODO
 * @Author loren
 * @Date 2019/2/18 8:01 PM
 * @Version 1.0
 **/
public class MergeSortedArray {

    public static void main(String[] args) {

    }

    public static int[] mergeSortedArray(int[] a, int[] b) {
        if (a == null || a.length < 0) {
            return b;
        }

        if (b == null || b.length < 0) {
            return a;
        }

        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[z++] = a[i++];
            } else {
                c[z++] = b[j++];
            }
        }

        while (i < a.length) {
            c[z++] = a[i++];
        }

        while (j < b.length) {
            c[z++] = b[j++];
        }

        return c;
    }

}
