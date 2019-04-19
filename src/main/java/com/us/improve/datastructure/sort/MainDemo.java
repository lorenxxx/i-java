package com.us.improve.datastructure.sort;

/**
 * @ClassName MainDemo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/4/8 2:54 PM
 * @Version 1.0
 **/
public class MainDemo {

    public static void main(String[] args) {
        int[] array = new int[] {1, 10, 5, 7, 9, 6, 4};

        //BubbleSort sorter = new BubbleSort();
        //InsertionSort sorter = new InsertionSort();
        //SelectionSort sorter = new SelectionSort();
        ShellSort sorter = new ShellSort();
        sorter.sort(array);
        sorter.display(array);
    }

}
