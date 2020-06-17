package com.yiqiandewo.hash;

/**
 * 哈希
 *
 * 冲突解决 链地址法(拉链法)
 */
public class MyHashtable {
    Node[] head;

    public MyHashtable() {
        head = new Node[10];
        //自定义对象数组，需要对数组中的每个对象元素独立进行创建，然后才可以对其赋值、引用等操作，如果没有单独对每个对象元素创建，会导致空指针异常
        for (int i = 0; i < head.length; i++) {
            head[i] = new Node();
        }
    }

    //添加元素
    public void put(Node node) {
        //首先寻址
        int key = hash(node.val);

        //找到所在的链表 然后插入
        //来到该条链表的链尾
        Node temp = head[key].next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //删除
    public void del(int val) {
        //首先找到要删除的node
        int key = hash(val);

        Node temp = head[key];
        if (temp.next == null) {
            System.out.println("没有该结点");
            return;
        }
        while (temp.next.val != val) {
            temp = temp.next;
            if (temp.next == null) {
                return;
            }
        }
        //找到了要删除结点的前一个结点
        temp.next = temp.next.next;
    }

    //查找
    public Node find(int val) {
        int key = hash(val);

        Node temp = head[key].next;

        if (temp == null) {
            System.out.println("没有该结点");
            return null;
        }
        while (temp.val != val) {
            temp = temp.next;
            if (temp == null) {
                return null;
            }
        }
        return temp;
    }

    //采用除留余数法
    private int hash(int val) {
        return (val % head.length);
    }
}

class Node {
    int val;
    Node next;

    public Node() {
        this.val = -1;
    }

    public Node(int val) {
        this.val = val;
        next = null;
    }
}