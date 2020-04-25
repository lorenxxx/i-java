package com.us.improve.threadpool;

import java.util.concurrent.*;

/**
 * @ClassName HowToCreateThreadPool
 * @Desciption 如何正确的创建线程池
 * @Author loren
 * @Date 2020/4/20 12:21 AM
 * @Version 1.0
 **/
public class HowToCreateThreadPool {

    public static void main(String[] args) {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS, queue, rejectedExecutionHandler);
    }

}
