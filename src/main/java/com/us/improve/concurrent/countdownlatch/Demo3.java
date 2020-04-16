package com.us.improve.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo3
 * @Desciption TODO
 * @Author loren
 * @Date 2019/7/19 3:05 AM
 * @Version 1.0
 **/
public class Demo3 {

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.countDown();
                    latch.countDown();
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " done");
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
        latch.await();

        System.out.println(Thread.currentThread() + " done");
    }

}
