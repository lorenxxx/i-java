package com.us.improve.algorithm.linkedlist;

/**
 * @ClassName Demo
 * @Desciption TODO
 * @Author loren
 * @Date 2019/3/25 10:41 AM
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {
        UsLinkedList<String> list = new UsLinkedList<>();
        list.addFirst("Loren");
        list.addFirst("Frank");
        list.addFirst("Tom");

        list.addLast("Jerry");
        list.addLast("Lucy");

        list.display();

        System.out.println(list.peekHead().getData());
        System.out.println(list.peekTail().getData());
    }


}
