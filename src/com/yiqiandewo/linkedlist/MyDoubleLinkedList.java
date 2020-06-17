package com.yiqiandewo.linkedlist;

public class MyDoubleLinkedList {
    private NodeDouble head;

    public MyDoubleLinkedList() {
        head = new NodeDouble(-1);
    }

    public NodeDouble getHead() {
        return head;
    }

    public void addHead(int val) {
        NodeDouble p = head;
        NodeDouble pNew = new NodeDouble(val);
        if (p.next == null) {
            p.next = pNew;
            pNew.prev = p;
        } else {
            pNew.next = p.next;
            p.next = pNew;
            pNew.next.prev = pNew;
            pNew.prev = head;
        }
    }

    public void addTail(int val) {
        NodeDouble p = head;
        NodeDouble pNew = new NodeDouble(val);
        while (p.next != null) {
            p = p.next;
        }
        p.next = pNew;
        pNew.prev = p;

    }

    public void addByOrder(int val) {
        NodeDouble p = head;
        NodeDouble pNew = new NodeDouble(val);
        while (true) {
            if (p.next == null) {
                p.next = pNew;
                pNew.prev = p;
                break;
            } else if (p.next.val < pNew.val) {
                p = p.next;
            } else {
                pNew.next = p.next;
                p.next = pNew;
                pNew.next.prev = pNew;
                pNew.prev = p;
            }
        }
    }

    public void update(int val, int newVal) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        NodeDouble p = head.next;
        while (p != null) {
            if (p.val == val) {
                p.val = newVal;
                break;
            }
        }
    }

    public void del(int val) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        NodeDouble p = head.next;
        while (p != null) {
            if (p.val == val) {
                p.prev.next = p.next;
                if (p.next != null) { //如果是最后一个节点 就不执行
                    p.next.prev = p.prev;
                }

            }
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        NodeDouble p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
        }
        System.out.println();
    }
}

class NodeDouble {
    public int val;
    public NodeDouble next;
    public NodeDouble prev;

    public NodeDouble(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}
