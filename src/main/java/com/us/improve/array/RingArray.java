package com.us.improve.array;

/**
 * @ClassName RingArray
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/12/14 16:04
 * @Version 1.0
 **/
public class RingArray {

    private int[] elementData;

    private int length;

    public RingArray(int length) {
        this.length = length;
        this.elementData = new int[length];
    }

    public int get(int index) {
        index = index % length;
        return elementData[index];
    }

    public void set(int index, int value) {
        index = index % length;
        elementData[index] = value;
    }

}
