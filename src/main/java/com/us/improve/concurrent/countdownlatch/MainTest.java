package com.us.improve.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Loren on 2018/11/10.
 */
public class MainTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " start working.");
                    Thread.sleep(13000);
                    System.out.println(Thread.currentThread().getName() + " done.");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " start working.");
                    Thread.sleep(17000);
                    System.out.println(Thread.currentThread().getName() + " done.");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println(Thread.currentThread().getName() + " waiting.");
            latch.await();
            System.out.println(Thread.currentThread().getName() + " remaining.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
