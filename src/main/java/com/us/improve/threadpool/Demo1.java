package com.us.improve.threadpool;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName Demo1
 * @Desciption TODO
 * @Author loren
 * @Date 2019/7/18 8:59 PM
 * @Version 1.0
 **/
public class Demo1 {

    private static ExecutorService es = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws Exception {
        // 开始监视
        Thread monitorThread = new Thread(new ThreadPoolMonitor((ThreadPoolExecutor) es));
        monitorThread.start();

        List<FirstLevelTask> firstLevelTasks = new ArrayList<>();
        CountDownLatch firstLevelLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            FirstLevelTask task = new FirstLevelTask("FirstLevelTask-" + i, firstLevelLatch);
            firstLevelTasks.add(task);
        }

        TimeUnit.SECONDS.sleep(5);

        for (FirstLevelTask firstLevelTask : firstLevelTasks) {
            es.execute(firstLevelTask);
        }
        System.out.println("Add First Level Task Done!!!");

        firstLevelLatch.await();
        System.out.println("All Task Done!!!");
    }

    static class ThreadPoolMonitor implements Runnable {

        private ThreadPoolExecutor threadPoolExecutor;

        public ThreadPoolMonitor(ThreadPoolExecutor threadPoolExecutor) {
            this.threadPoolExecutor = threadPoolExecutor;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println();

                int queueSize = threadPoolExecutor.getQueue().size();
                System.out.println("当前排队线程数：" + queueSize);

                int activeCount = threadPoolExecutor.getActiveCount();
                System.out.println("当前活动线程数：" + activeCount);

                long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
                System.out.println("执行完成线程数：" + completedTaskCount);

                long taskCount = threadPoolExecutor.getTaskCount();
                System.out.println("总线程数：" + taskCount);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Data
    static class FirstLevelTask implements Runnable {

        private String name;

        private CountDownLatch countDownLatch;

        public FirstLevelTask(String name, CountDownLatch countDownLatch) {
            this.name = name;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + name + " running...");

                //TimeUnit.SECONDS.sleep(1);

                List<SecondLevelTask> secondLevelTasks = new ArrayList<>();
                CountDownLatch secondLevelLatch = new CountDownLatch(20);
                for (int i = 0; i < 20; i ++) {
                    SecondLevelTask secondLevelTask = new SecondLevelTask(name + "|SecondLevelTask-" + i, secondLevelLatch);
                    secondLevelTasks.add(secondLevelTask);
                }

                for (SecondLevelTask secondLevelTask : secondLevelTasks) {
                    es.execute(secondLevelTask);
                }

                secondLevelLatch.await();

                System.out.println(Thread.currentThread().getName() + ": " + name + " done...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    @Data
    static class SecondLevelTask implements Runnable {

        private String name;

        private CountDownLatch countDownLatch;

        public SecondLevelTask(String name, CountDownLatch countDownLatch) {
            this.name = name;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + name + " running...");

                TimeUnit.SECONDS.sleep(5);

                System.out.println(Thread.currentThread().getName() + ": " + name + " done...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }


}

