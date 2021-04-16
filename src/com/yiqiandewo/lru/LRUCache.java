package com.yiqiandewo.lru;

import java.util.HashMap;

public class LRUCache {

    class DLinkedNode {
        private int key;
        private int value;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        //要将key移到链表首部
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //key不存在  put进去
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            //如果size大于容量
            if (size > capacity) {
                DLinkedNode remove = removeTail();
                cache.remove(remove.key);
                size--;
            }
        } else { //key存在
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail()  {
        DLinkedNode temp = tail.pre;
        removeNode(temp);
        return temp;
    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode temp = head.next;
        head.next = node;
        node.next = temp;
        temp.pre = node;
        node.pre = head;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
