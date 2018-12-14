package com.us.improve.array;

import java.util.Arrays;

/**
 * Created by Loren on 2018/11/13.
 */
public class MainTest {

    public static void main(String[] args) {
        int[] ints = new int[] {5, 10, 1, 9};
        String[] strings = new String[] {"abc", "edf"};

        System.out.println(ints.length);
        System.out.println(strings.length);

        String cube[][] = new String[2][3];

        Arrays.sort(ints);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println(Arrays.binarySearch(ints, 11));
    }

}
