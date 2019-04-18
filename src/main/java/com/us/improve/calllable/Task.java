package com.us.improve.calllable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Task
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/21 9:33 PM
 * @Version 1.0
 **/
public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread() + " start working");
        TimeUnit.SECONDS.sleep(10);
        return "Hello Callable";
    }

}
