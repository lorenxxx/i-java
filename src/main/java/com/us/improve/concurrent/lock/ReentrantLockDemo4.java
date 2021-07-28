package com.us.improve.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author loren
 * @Description ReentrantLock响应中断
 * @Date 2021-07-10 14:07
 * @Version 1.0
 **/
public class ReentrantLockDemo4 {

	/**
	 * 模拟一个死锁场景，然后执行中断
	 */

	private static final Lock lock1 = new ReentrantLock();

	private static final Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		 Thread t1 = new Thread(new Task(lock1, lock2), "T1");
		 Thread t2 = new Thread(new Task(lock2, lock1), "T2");

		 t1.start();
		 t2.start();

		 t1.interrupt();
	}

	static class Task implements Runnable {

		private Lock firstLock;

		private Lock secondLock;

		public Task(Lock firstLock, Lock secondLock) {
			this.firstLock = firstLock;
			this.secondLock = secondLock;
		}

		@Override
		public void run() {
			try {
				firstLock.lockInterruptibly();

				TimeUnit.SECONDS.sleep(2);

				secondLock.lockInterruptibly();

				System.out.println("线程[" + Thread.currentThread().getName() + "]获取了两把锁");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				firstLock.unlock();
				secondLock.unlock();
				System.out.println("线程[" + Thread.currentThread().getName() + "]释放了两把锁，正常结束");
			}
		}

	}

}
