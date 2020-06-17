package com.yiqiandewo.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList c = new CircleLinkedList();
        c.create(6);
        c.del(1, 5);
    }
}

/**
 * 环形单链表
 */
class CircleLinkedList {
    private Node first;

    public void create(int counts) {
        first = new Node(1);
        first.next = first;
        Node p = first;
        for (int i = 2; i <= counts; i++) {
            Node node = new Node(i);
            p.next = node;
            node.next = first;
            p = p.next;
        }
    }

    public void del(int start, int step) {
        Node p = first;
        while (p.next != first) {
            p = p.next;
        }
        for (int i = 0; i < start-1; i++) {
            first = first.next;
            p = p.next;
        }
        while (first != p) {
            for(int i = 0; i < step-1; i++) {
                first = first.next;
                p = p.next;
            }
            System.out.print(first.val + " ");
            first = first.next;
            p.next = first;
        }
        System.out.println(p.val);
    }

}
