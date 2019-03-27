package com.us.improve.datastructure.queue;

/**
 * @ClassName ArrayQueue
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/27 11:51 AM
 * @Version 1.0
 **/
public class ArrayQueue<T> implements IQueue<T> {

    private Object[] elementData;

    private int capacity;

    private int size;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }

        elementData = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean enqueue(T t) {
        if (size == capacity) {
            return false;
        }

        elementData[tail++] = t;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T t = (T) elementData[head++];
        size--;
        return t;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
