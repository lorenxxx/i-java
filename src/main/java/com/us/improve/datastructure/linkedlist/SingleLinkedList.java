package com.us.improve.datastructure.linkedlist;

import com.us.improve.datastructure.Collection;
import lombok.Data;

/**
 * @ClassName UniDirectionalLinkedList
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/29 4:13 PM
 * @Version 1.0
 **/
@Data
public class SingleLinkedList<E> implements Collection<E> {

    private Node sentinel;

    private Node head;

    private int size;

    public SingleLinkedList() {
        sentinel = new Node(null);
        sentinel.next = head;
    }

    public void addFisrt(E e) {
        Node node = new Node(e);

        node.next = head;
        head = node;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            // do nothing
        } else {

        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    public void display() {
        Node temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data + " *> ");
            temp = temp.next;
        }

        int trimOffset = builder.lastIndexOf(" -> ");
        if (trimOffset > 0) {
            builder.delete(trimOffset, builder.length());
        }
        System.out.println(builder.toString());
    }

    @Data
    private class Node<E> {

        private E data;

        private Node next;

        public Node() {
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }

    }

}
