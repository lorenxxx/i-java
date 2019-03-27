package com.us.improve.datastructure.queue;

/**
 * @ClassName IQueue
 * @Desciption 队列接口定义
 * @Author loren
 * @Date 2019/3/27 11:59 AM
 * @Version 1.0
 **/
public interface IQueue<T> {

    boolean enqueue(T t);

    T dequeue();

    int size();

    boolean isEmpty();

}