package com.us.improve.concurrent.threadlocal;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author Loren
 * @Date 2018/11/30 19:16
 * @Version 1.0
 **/
public class MainTest {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello");
        System.out.println(Thread.currentThread() + ": " + threadLocal.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("world");
                System.out.println(Thread.currentThread() + ": " + threadLocal.get());
            }
        }).start();
    }

}
