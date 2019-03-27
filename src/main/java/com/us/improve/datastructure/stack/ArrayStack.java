package com.us.improve.datastructure.stack;

/**
 * @ClassName ArrayStack
 * @Desciption 用数组实现的栈，顺序栈
 * @Author loren
 * @Date 2019/3/27 11:51 AM
 * @Version 1.0
 **/
public class ArrayStack<T> implements IStack<T> {

    private Object[] elementData;

    private int capacity;

    private int size;

    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }

        elementData = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean push(T t) {
        ensureCapacity();
        elementData[size++] = t;
        return true;
    }

    @Override
    public T pop() {
        // 栈空的时候，返回null
        if (size == 0) {
            return null;
        }

        return (T) elementData[--size];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = capacity + capacity >> 1;
            Object[] newElementData = new Object[newCapacity];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            elementData = newElementData;
        }
    }

}
