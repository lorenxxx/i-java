package com.us.improve.concurrent.juc.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-10 17:55
 * @Version 1.0
 **/
public class ExchangerDemo1 {

	private static final Exchanger<String> EXCHANGER = new Exchanger();

	public static void main(String[] args) {
		new Thread(new Task(EXCHANGER, "T1 msg..."), "T1").start();
		new Thread(new Task(EXCHANGER, "T2 msg..."), "T2").start();
		//new Thread(new Task(EXCHANGER, "T3 msg..."), "T3").start();
	}

	static class Task implements Runnable {

		private Exchanger<String> exchanger;

		private String sendText;

		private String receiveText;

		public Task(Exchanger exchanger, String sendText) {
			this.exchanger = exchanger;
			this.sendText = sendText;
		}

		@Override
		public void run() {
			try {
				int random = new Random().nextInt(10);
				System.out.println("Thread[" + Thread.currentThread().getName() + "] sleep: " + random);

				TimeUnit.SECONDS.sleep(random);

				receiveText = exchanger.exchange(sendText);
				System.out.println("Thread[" + Thread.currentThread().getName() + "] send text: " + sendText + ", receive text: " + receiveText);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
