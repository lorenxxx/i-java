package com.us.improve.tencent;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-26 14:07
 * @Version 1.0
 **/
public class Demo {

	/**
	 * 给你一个整数n, 一个数组 长度为n,  数组中元素 范围 0<= x <=n  ，顺序递增，求丢失的一个元素。不要用复杂度O(n)的算法。
	 * <p>
	 * 示例：n=4,  arr=[0,1,2,4]  ,结果为 3；
	 * <p>
	 * n=2, arr=[0,1] ,结果为2.
	 */

	public static int getMiss(int[] arr, int n) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		if (arr[0] != 0) {
			return 0;
		}

		if (arr[arr.length - 1] != (n - 1)) {
			return n - 1;
		}

		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] <= mid) {
				left = mid + 1;
			} else if (arr[mid] > mid) {
				if (mid == 0) {
					return mid;
				} else if (mid > 0 && arr[mid - 1] == (mid - 1)) {
					return mid;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 4 };
		System.out.println(Demo.getMiss(arr, 5));

		arr = new int[] { 0, 1, 3, 4 };
		System.out.println(Demo.getMiss(arr, 5));

		arr = new int[] { 0, 1 };
		System.out.println(Demo.getMiss(arr, 3));

		arr = new int[] { 1, 2 };
		System.out.println(Demo.getMiss(arr, 3));

		arr = null;
		System.out.println(Demo.getMiss(arr, 1));
	}

}
