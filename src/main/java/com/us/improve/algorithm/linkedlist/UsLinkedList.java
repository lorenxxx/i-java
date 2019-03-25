package com.us.improve.algorithm.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UsLinkedList
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/25 10:52 AM
 * @Version 1.0
 **/
public class UsLinkedList<T> {

    private Node head;

    private Node tail;

    public void addFirst(T t) {
        checkNull(t);
        Node n = new Node(t);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void addLast(T t) {
        checkNull(t);
        Node n = new Node(t);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
    }


    public void removeLast() {
        if (tail == null) {
            return;
        }

    }

    public void remove(Node n) {
        checkNull(n);
        if (head == null) {
            return;
        }

        
    }

    public Node peekHead() {
        return head;
    }

    public Node peekTail() {
        return tail;
    }

    public void display() {
        Node idx = head;
        while (idx != null) {
            System.out.println("data: " + idx.data);
            idx = idx.next;
        }
    }

    private <T> void checkNull(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNull(Node n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class Node<T> {

        private T data;

        private Node prev;

        private Node next;

        public Node(T t) {
            this(t, null, null);
        }

    }




}
