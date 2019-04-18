package com.us.improve.calllable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/21 9:33 PM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread());
        FutureTask<String> futureTask = new FutureTask(new Task());


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask);

        while (true) {
            System.out.println("checking...");
            if (futureTask.isDone()) {
                System.out.println("done!");
                break;
            }

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(futureTask.get(5, TimeUnit.SECONDS));
        executorService.shutdown();

    }

}
