package com.us.improve.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 15:20
 * @Version 1.0
 **/
public class CreateThreadPool {

	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.submit(new Task());
		cachedThreadPool.shutdown();

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		fixedThreadPool.submit(new Task());
		fixedThreadPool.shutdown();

		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		singleThreadExecutor.submit(new Task());
		singleThreadExecutor.shutdown();

		/**
		 * 最好以自定义的方式创建线程池
		 *
		 * 1、避免使用无界队列
		 * 2、明确拒绝策略
		 */
		ExecutorService customThreadPool = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(512), new LogPolicy());
		customThreadPool.submit(new Task());
		customThreadPool.shutdown();
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread() +  " -> go go go...");
		}

	}

	static class LogPolicy implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			// log
			System.out.println("log...");
		}

	}

}


