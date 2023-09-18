package com.us.improve.array;

import java.util.Arrays;

/**
 * @Author loren
 * @Description 环形数组
 * @Date 2023-09-18 23:46
 * @Version 1.0
 **/
public class RingArray<T> {

	private Object[] elementData;

	private int length;

	public RingArray(int length) {
		this.length = length;
		this.elementData = new Object[length];
	}

	public T get(int index) {
		return (T) elementData[index / this.length];
	}

	public void set(int index, T value) {
		this.elementData[index % this.length] = value;
	}

	public void display() {
		System.out.println(Arrays.toString(this.elementData));
	}

	public static void main(String[] args) {
		RingArray<Integer> ringArray = new RingArray<>(10);
		ringArray.set(0, 100);
		ringArray.display();

		System.out.println(ringArray.get(0));
	}

}
