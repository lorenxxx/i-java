package com.us.improve.concurrent.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-10 17:38
 * @Version 1.0
 **/
public class SemaphoreDemo1 {

	private static final Semaphore SEMAPHORE = new Semaphore(0);

	public static void main(String[] args) {
		int threadCount = 1;

		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

		for (int i = 0; i < threadCount; i++) {
			executorService.submit(new Task(SEMAPHORE));
		}

		executorService.shutdown();
	}

	static class Task implements Runnable {

		private Semaphore semaphore;

		public Task(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("Thread[" + Thread.currentThread().getName() + "] acquire semaphore success, run...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
				System.out.println("Thread[" + Thread.currentThread().getName() + "] release semaphore");
			}
		}

	}

}
