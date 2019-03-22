package com.us.improve.datastructure;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName Queue
 * @Desciption TODO
 * @Author loren
 * @Date 2018/12/28 7:49 PM
 * @Version 1.0
 **/
public class Queue {

    /**
     * store elements
     */
    private List<Integer> data;

    private int head;

    public Queue() {
        data = Lists.newArrayList();
        head = 0;
    }

    public boolean enqueue(int x) {
        data.add(x);
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }

        head++;
        return true;
    }

    public boolean isEmpty() {
        return head >= data.size();
    }

    public int front() {
        return data.get(head);
    }
}
