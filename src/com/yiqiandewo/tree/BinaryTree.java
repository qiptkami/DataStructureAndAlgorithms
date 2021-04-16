package com.yiqiandewo.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 二叉树
 * 先序、中序、后序、层次
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        TreeNode node1 = new TreeNode("B");
        TreeNode node2 = new TreeNode("C");
        TreeNode node3 = new TreeNode("D");
        TreeNode node4 = new TreeNode("E");
        TreeNode node5 = new TreeNode("F");
        TreeNode node6 = new TreeNode("G");

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;
        node4.left = node5;

        System.out.println("先序");
        preOrder(root);
        System.out.println();

        System.out.println("中序");
        inOrder(root);
        System.out.println();

        System.out.println("后序");
        postOrder(root);
        System.out.println();

        System.out.println("非递归先序");
        preOrderWithoutRecursion(root);
        System.out.println();

        System.out.println("非递归中序");
        inOrderWithoutRecursion(root);
        System.out.println();

        System.out.println("非递归后序");
        postOrderWithoutRecursion(root);
        System.out.println();

        System.out.println("层次遍历");
        levelOrder(root);
        System.out.println();
        //ThreadedBinaryTree.inOrderThreaded(root);

        //ThreadedBinaryTree.printInOrderThreaded(root);
        System.out.println("===");

        //postOrderTraversal(root);
    }

    public static void postOrderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastVisited = null;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.offerLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pollLast();
                if (node.right == null || lastVisited == node.right) { //右子树已经访问过或者右子树不存在
                    //直接访问根节点
                    System.out.println(node.val + " ");
                    lastVisited = node;
                    node = null;
                } else { //遍历右子树
                    stack.offerLast(node);   //由于node已经出栈 但是node还未被访问
                    node = node.right;
                }
            }
        }

    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    //非递归先序
    public static void preOrderWithoutRecursion(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {  //栈是先进后出，所以先将右子树入栈
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void preOrder1(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.offerLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pollLast();
                node = node.right;
            }
        }
    }



    //非递归中序
    public static void inOrderWithoutRecursion(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            //一直遍历到左子树最下边，边遍历边保存根节点到栈中
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //当p为空时，说明已经到达左子树最下边，这时需要出栈了
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                //进入右子树，开始新的一轮左子树遍历
                node = node.right;
            }
        }
    }

    //在遍历完左子树时不能访问根，需要先遍历右子树，然后才能访问根。
    //在遍历完左子树后，必须判断根的右子树是否为空或根的右子树是否被访问过。
    //如果根的右子树为空或者右子树被访问过，就应该访问根，如果没有，就应该遍历右子树
    public static void postOrderWithoutRecursion(TreeNode root) {
        TreeNode node = root;
        TreeNode nodeVisited = null; //上一次访问的结点
        Stack<TreeNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            //判断有没有右子树或者右子树有没有访问过
            if (node.right == null || node.right == nodeVisited) {
                System.out.print(node.val + " ");
                nodeVisited = node;
            } else {
                //访问右子树
                stack.push(node);
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    String val;

    //线索化
    boolean isLeftThreaded;
    boolean isRightThreaded;

    public TreeNode() {
        left = null;
        right = null;
        val = null;
        isLeftThreaded = false;
        isRightThreaded = false;
    }

    public TreeNode(String val) {
        this();
        this.val = val;
    }
}

