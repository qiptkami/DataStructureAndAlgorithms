package com.yiqiandewo.tree;

/**
 * 平衡二叉搜索树
 */
public class AVLTree {

    static AVLNode root;
    public void createAVL(int[] arr) {

    }


    public AVLNode search(int val) {
        AVLNode node = root;
        while (node != null) {
            if (node.val > val) {
                //说明在左子树
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }
}

class AVLNode {
    AVLNode left;
    AVLNode right;
    int val;

    public AVLNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    //返回以该结点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public void leftRotate() {

    }

    public void rightRotate() {

    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                '}';
    }
}
