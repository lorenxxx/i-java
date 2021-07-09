package com.us.improve.concurrent.producer_and_concumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author loren
 * @Description 使用阻塞队列实现生产者消费者模型
 * @Date 2021-07-09 16:05
 * @Version 1.0
 **/
public class Demo3 {

	private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue(5);

	public static void main(String[] args) {
		Thread producer1 = new Thread(new Producer("p1"));
		Thread producer2 = new Thread(new Producer("p2"));
		Thread consumer1 = new Thread(new Consumer("c1"));
		Thread consumer2 = new Thread(new Consumer("c2"));
		Thread consumer3 = new Thread(new Consumer("c3"));
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}

	static class Producer implements Runnable {

		private String name;

		public Producer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			while (true) {
				Integer value = new Random().nextInt(100);

				try {
					queue.put(value);
					System.out.println("Producer[" + name + "] producing value: " + value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class Consumer implements Runnable {

		private String name;

		public Consumer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Integer value = queue.take();
					System.out.println("Consumer[" + name + "] consuming value: " + value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
