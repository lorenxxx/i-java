package com.us.improve.concurrent.producer_and_concumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author loren
 * @Description 使用Object类的wait()、notify()|notifyAll()实现生产者消费者模型
 * @Date 2021-07-09 15:02
 * @Version 1.0
 **/
public class Demo1 {

	/**
	 * notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，选择哪个线程取决于操作系统对多线程管理的实现。
	 * notifyAll 会唤醒所有等待(对象的)线程，尽管哪一个线程将会第一个处理取决于操作系统的实现。如果当前情况下有多个线程需要被唤醒，推荐使用notifyAll 方法
	 */

	private static final Queue<Integer> queue = new LinkedList<>();

	private static final Integer maxSize = 5;

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
				synchronized (queue) {
					// 此处不能使用if进行判断，一方面是为了防止唤醒其他的生产者线程，另一方面需要防止"虚假唤醒"，因此需要自旋
					while (queue.size() == maxSize) {
						try {
							System.out.println("Queue is full, Producer[" + name + "] thread waiting for consumer to take something from queue.");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					Integer value = new Random().nextInt(100);
					queue.offer(value);
					System.out.println("Producer[" + name + "] producing value: " + value);

					queue.notifyAll();
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
				synchronized (queue) {
					// 此处不能使用if进行判断，一方面是为了防止唤醒其他消费者的线程，另一方面需要防止"虚假唤醒"，因此需要自旋
					while (queue.isEmpty()) {
						try {
							System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					Integer value = queue.poll();
					System.out.println("Consumer[" + name + "] consuming value: " + value);

					queue.notifyAll();
				}
			}
		}
	}

}
