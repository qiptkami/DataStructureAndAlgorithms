package com.yiqiandewo.linkedlist;

public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
        head = new Node(-1);
    }

    public Node getHead() {
        return head;
    }

    public void addHead(int val) {
        Node p = head;
        Node pNew = new Node(val);
        pNew.next = p.next;
        p.next = pNew;
    }

    public void addTail(int val) {
        Node p = head;
        Node pNew = new Node(val);
        while (p.next != null) {
            p = p.next;
        }
        p.next = pNew;
    }

    //按从小到大的顺序插入
    public void addByOrder(int val) {
        Node p = head;
        Node pNew = new Node(val);
        while (true) {
            if (p.next == null) { //位于链表最后
                p.next = pNew;
                break;
            } else if (p.next.val < pNew.val) {
                p = p.next;
            } else {
                pNew.next = p.next;
                p.next = pNew;
                break;
            }
        }
    }

    public void update(int val, int newVal) {
        Node p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next.val = newVal;
                break;
            }
            p = p.next;
        }
        if (p.next == null) {
            System.out.println("未找到该节点");
        }
    }

    public void del(int val) {
        Node p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        if (p.next == null) {
            System.out.println("未找到该节点");
        }
    }

    public void reverse() {
        Node prev = null;
        Node p = head.next;
        while (p != null) {
            Node temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        head.next = prev;
    }

    public void traverse() {
        Node p = head.next;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}