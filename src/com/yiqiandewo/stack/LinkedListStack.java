package com.yiqiandewo.stack;

public class LinkedListStack<T> {
    private Node top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public void push(T val) {
        Node node = new Node(val);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        size--;
        return (T)temp.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T getTop() {
        return (T)top.val;
    }
}

class Node<T> {
    T val;
    Node next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}