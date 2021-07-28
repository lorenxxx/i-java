package com.us.improve.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * @Author loren
 * @Description 如何创建线程
 * @Date 2021-07-10 12:44
 * @Version 1.0
 **/
public class CreateThread {

	static class Task1 extends Thread {

		@Override
		public void run() {
			System.out.println("do something...");
		}

	}

	static class Task2 implements Runnable {

		@Override
		public void run() {
			System.out.println("do something...");
		}

	}

	static class Task3 implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println("do something");
			return "ok";
		}

	}

}
