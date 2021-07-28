package com.us.improve.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author loren
 * @Description ReentrantLock基本使用
 * @Date 2021-07-10 13:38
 * @Version 1.0
 **/
public class ReentrantLockDemo1 {

	private static final Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(() -> test(), "T1").start();
		new Thread(() -> test(), "T2").start();
	}

	public static void test() {
		try {
			lock.lock();

			System.out.println("线程[" + Thread.currentThread().getName() + "]获取了锁");

			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("线程[" + Thread.currentThread().getName() + "]释放了锁");
		}

	}

}
