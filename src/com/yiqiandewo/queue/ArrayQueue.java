package com.yiqiandewo.queue;

public class ArrayQueue {
    private int MAXSIZE;
    private int front; //队头
    private int rear;  //队尾
    private int[] arr;

    public ArrayQueue(int maxSize) {
        MAXSIZE = maxSize;
        arr = new int[MAXSIZE];
        front = -1;
        rear = -1;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判满
     * @return
     */
    public boolean isFull() {
        return rear == MAXSIZE - 1;
    }

    /**
     * 返回队头元素
     */
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队空");
        }
        return arr[front+1];
    }

    /**
     * 出队
     */
    public int outQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队空");
        }
        return arr[++front];
    }

    /**
     * 入队
     */
    public void inQueue(int val) {
        if (isFull()) {
            throw new RuntimeException("队满");
        }
        rear++;
        arr[rear] = val;
    }
}