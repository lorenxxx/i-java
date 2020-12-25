package com.us.improve.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Demo1
 * @Desciption TODO
 * @Author loren
 * @Date 2020/8/19 20:23
 * @Version 1.0
 **/
public class Demo1 {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(10);
        blockingQueue.offer(1);
        Integer item = blockingQueue.poll();
        System.out.println(item);
    }

}
