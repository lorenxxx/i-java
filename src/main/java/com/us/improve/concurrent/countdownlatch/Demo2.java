package com.us.improve.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Demo2
 * @Desciption TODO
 * @Author loren
 * @Date 2019/1/9 8:36 PM
 * @Version 1.0
 **/
public class Demo2 {

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(2);

        latch.countDown();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + ": start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(Thread.currentThread() + ": done");
            }
        }).start();

        latch.await();

        System.out.println(Thread.currentThread() + ": done");
    }

}
