package com.us.improve.concurrent.interrupt;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-28 13:41
 * @Version 1.0
 **/
public class Demo1 {

	/**
	 * 线程在不同状态下对于中断所产生的反应
	 *
	 * NEW和TERMINATED
	 *
	 * 线程的new状态表示还未调用start方法，还未真正启动。线程的terminated状态表示线程已经运行终止。这两个状态下调用中断方法来中断线程的时候，Java认为毫无意义，所以并不会设置线程的中断标识位，什么事也不会发生。
	 */

	public static void main(String[] args) {
		Thread thread = new Thread();

		System.out.println(thread.getState());

		thread.interrupt();

		System.out.println(thread.isInterrupted());

	}

}
