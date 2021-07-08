package com.us.improve.concurrent.demo;

/**
 * @Author loren
 * @Description 两个线程交替打印1 ~ 100
 * @Date 2021-07-06 17:05
 * @Version 1.0
 **/
public class Demo1 {

	public static void main(String[] args) {
		Demo1Runner runner = new Demo1Runner();
		Thread t1 = new Thread(runner);
		Thread t2 = new Thread(runner);

		t1.setName("线程1");
		t2.setName("线程2");

		t1.start();
		t2.start();
	}

}

class Demo1Runner implements Runnable {

	private int i = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (i <= 100) {
					System.out.println(Thread.currentThread().getName() + " -> " + i);
					i++;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
