package com.yiqiandewo.queue;

/**
 * 数组环形队列
 */
public class CircleArrayQueue {
    private int front;
    private int rear;
    private int MAXSIZE;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        MAXSIZE = maxSize;
        arr = new int[MAXSIZE];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear+1)%MAXSIZE == front;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队空");
        }
        return arr[front];
    }

    public void inQueue(int val) {
        if (isFull()) {
            throw new RuntimeException("队满");
        }

        arr[rear] = val;
        rear = (rear+1) % MAXSIZE;
    }

    public int outQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队空");
        }
        int val = arr[front];
        front = (front+1) % MAXSIZE;
        return val;
    }

    /**
     * 队列的有效数字个数
     * @return
     */
    public int size() {
        return (rear + MAXSIZE - front) % MAXSIZE;
    }

}
