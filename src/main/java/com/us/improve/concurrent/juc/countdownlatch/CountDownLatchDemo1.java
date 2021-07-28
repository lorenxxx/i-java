package com.us.improve.concurrent.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-10 17:16
 * @Version 1.0
 **/
public class CountDownLatchDemo1 {

	private static final CountDownLatch LATCH = new CountDownLatch(1);

	public static void main(String[] args) {
		System.out.println("Thread[" + Thread.currentThread().getName() + "] run...");

		new Thread(new Task(LATCH), "T1").start();
		//new Thread(new Task(LATCH), "T2").start();

		try {
			LATCH.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread[" + Thread.currentThread().getName() + "] done...");
	}

	static class Task implements Runnable {

		private CountDownLatch latch;

		public Task(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Thread[" + Thread.currentThread().getName() + "] run...");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
			}
		}

	}

}
