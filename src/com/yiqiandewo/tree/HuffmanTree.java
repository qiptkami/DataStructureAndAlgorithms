package com.yiqiandewo.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 哈夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 31, 42, 15};

        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    public static Node createHuffmanTree(int[] arr) {

        ArrayList<Node> nodes = new ArrayList<>();
        for (int a : arr) {
            nodes.add(new Node(a));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            //取前两个作为左右结点
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.val + right.val);

            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }

        return nodes.get(0);
    }

    private static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class Node implements Comparable<Node> {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
