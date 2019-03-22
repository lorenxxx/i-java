package com.us.improve.algorithm;

/**
 * @ClassName MergeSortedList
 * @Desciption TODO
 * @Author loren
 * @Date 2019/2/18 8:07 PM
 * @Version 1.0
 **/
public class MergeSortedList {

    public static void main(String[] args) {

    }

    public ListNode mergeSortedList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        ListNode h = new ListNode();
        ListNode p = h;
        while (a != null && b != null) {
            if (a.value < b.value) {
                h.next = a;
                a = a.next;
            } else {
                h.next = b;
                b = b.next;
            }
            h = h.next;
        }

        while (a != null) {
            h.next = a;
            a = a.next;
            h = h.next;
        }

        while (b != null) {
            h.next = b;
            b = b.next;
            h = h.next;
        }

        return p.next;
    }

    public ListNode mergeSortedList2(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        ListNode head = null;
        if (a.value < b.value) {
            head = a;
            mergeSortedList2(a.next, b);
        } else {
            head = b;
            mergeSortedList2(a, b.next);
        }

        return head;
    }

}

class ListNode {
    int value;
    ListNode next;
}
