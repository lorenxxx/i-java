package com.us.improve.threadpool;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName Demo2
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/20 12:31 AM
 * @Version 1.0
 **/
public class Demo2 {

    public static void main(String[] args) {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        System.out.println(poolSize);

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize * 2, 0, TimeUnit.SECONDS, queue, rejectedExecutionHandler);

        for (int i = 0; i < 500; i++) {
            executorService.execute(new Worker(i));
        }

        //executorService.shutdown();

    }

    @NoArgsConstructor
    @AllArgsConstructor
    private static class Worker implements Runnable {

        private int workerId;

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                System.out.println(Thread.currentThread().getName() + "run " + workerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
