package com.yiqiandewo.stack;

public class ArrayStack {
    private int MAXSIZE;
    private int top;
    private int[] stack;

    public ArrayStack(int maxSize) {
        top = -1;
        MAXSIZE = maxSize;
        stack = new int[MAXSIZE];
    }

    public boolean isFull() {
        return top == MAXSIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        top++;
        stack[top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    public int getTop() {
        return stack[top];
    }

    public void printStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
