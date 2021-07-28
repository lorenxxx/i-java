package com.us.improve.concurrent.juc.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-10 17:27
 * @Version 1.0
 **/
public class CyclicBarrierDemo1 {

	private static final CyclicBarrier BARRIER = new CyclicBarrier(3);

	public static void main(String[] args) {
		new Thread(new Task(BARRIER), "T1").start();
		new Thread(new Task(BARRIER), "T2").start();
		new Thread(new Task(BARRIER), "T3").start();
	}

	static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			System.out.println("Thread[" + Thread.currentThread().getName() + "] run...");

			try {
				TimeUnit.SECONDS.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				System.out.println("Thread[" + Thread.currentThread().getName() + "] await...");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

			System.out.println("Thread[" + Thread.currentThread().getName() + "] go on...");
		}

	}

}
