package com.us.improve.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author loren
 * @Description ReentrantReadWriteLock的基本使用，读-读不互斥，读-写互斥，写-写互斥
 * @Date 2021-07-15 16:48
 * @Version 1.0
 **/
public class ReentrantReadWriteLockDemo1 {

	private static final ReentrantReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

	private static final Lock READ_LOCK = READ_WRITE_LOCK.readLock();

	private static final Lock WRITE_LOCK = READ_WRITE_LOCK.writeLock();

	public static void main(String[] args) {
		Thread r1 = new Thread(new ReadOperation(), "R1");
		Thread r2 = new Thread(new ReadOperation(), "R2");
		Thread r3 = new Thread(new ReadOperation(), "R3");

		Thread w1 = new Thread(new WriteOperation(), "W1");
		Thread w2 = new Thread(new WriteOperation(), "W2");

		r1.start();
		r2.start();
		r3.start();

		w1.start();
		w2.start();
	}


	static class ReadOperation implements Runnable {

		@Override
		public void run() {
			try {
				READ_LOCK.lock();
				System.out.println("Thread[" + Thread.currentThread().getName() + "] read begin...");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Thread[" + Thread.currentThread().getName() + "] read end...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				READ_LOCK.unlock();
			}
		}

	}

	static class WriteOperation implements Runnable {

		@Override
		public void run() {
			try {
				WRITE_LOCK.lock();
				System.out.println("Thread[" + Thread.currentThread().getName() + "] write begin...");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Thread[" + Thread.currentThread().getName() + "] write end...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				WRITE_LOCK.unlock();
			}
		}

	}

}
