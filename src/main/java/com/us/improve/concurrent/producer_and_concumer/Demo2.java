package com.us.improve.concurrent.producer_and_concumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author loren
 * @Description 使用Lock的Condition实现生产者消费者模型
 * @Date 2021-07-09 15:53
 * @Version 1.0
 **/
public class Demo2 {

	private static final Queue<Integer> queue = new LinkedList<>();

	private static final Integer maxSize = 5;

	private static final Lock lock = new ReentrantLock();

	private static final Condition fullCondition = lock.newCondition();

	private static final Condition emptyCondition = lock.newCondition();

	public static void main(String[] args) {
		Thread producer1 = new Thread(new Producer("p1", queue));
		Thread producer2 = new Thread(new Producer("p2", queue));
		Thread consumer1 = new Thread(new Consumer("c1", queue));
		Thread consumer2 = new Thread(new Consumer("c2", queue));
		Thread consumer3 = new Thread(new Consumer("c3", queue));

		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}

	static class Producer implements Runnable {

		private String name;

		private Queue<Integer> queue;

		public Producer(String name, Queue<Integer> queue) {
			this.name = name;
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				lock.lock();

				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, Producer[" + name + "] thread waiting for consumer to take something from queue.");
						fullCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				Integer value = new Random().nextInt(100);
				queue.offer(value);
				System.out.println("Producer[" + name + "] producing value: " + value);

				emptyCondition.signalAll();

				lock.unlock();

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class Consumer implements Runnable {

		private String name;

		private Queue<Integer> queue;

		public Consumer(String name, Queue<Integer> queue) {
			this.name = name;
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				lock.lock();

				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
						emptyCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				Integer value = queue.poll();
				System.out.println("Consumer[" + name + "] consuming value: " + value);

				fullCondition.signalAll();

				lock.unlock();

				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
