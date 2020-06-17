package com.yiqiandewo.tree;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTree {

    private static TreeNode pre;

    //构造中序线索树
    public static void inOrderThreaded(TreeNode node) {
        if (node == null) {
            return;
        }
        //左
        inOrderThreaded(node.left);
        //根
        if (node.left == null) {
            node.left = pre;
            node.isLeftThreaded = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.isRightThreaded = true;
        }
        pre = node;
        //右
        inOrderThreaded(node.right);
    }

    //遍历中序线索树
    public static void printInOrderThreaded(TreeNode root) {

        TreeNode node = root;
        while (node != null) {
            while (!node.isLeftThreaded) {
                node = node.left;
            }
            System.out.print(node.val + " ");
            while (node.isRightThreaded) {
                node = node.right;
                System.out.print(node.val + " ");
            }
            node = node.right;
        }
    }
}