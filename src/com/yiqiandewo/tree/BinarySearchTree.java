package com.yiqiandewo.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    static BSTNode root;

    public static void main(String[] args) {
        int[] arr= {6, 3, 8, 2, 5, 1, 7};
        BinarySearchTree bst = new BinarySearchTree();
        bst.createBST(arr);

    }

    public void createBST(int[] arr) {
        root = new BSTNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            BSTNode node = root;
            while (node != null) {
                if (node.val > arr[i]) {
                    if (node.left == null) {
                        node.left = new BSTNode(arr[i]);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new BSTNode(arr[i]);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }

    //将被删结点向下移的过程
    public void remove(int val) {
        //首先查找被删除的结点
        BSTNode find = search(val);
        if (find == null) {
            return;
        }
        BSTNode temp = null;
        BSTNode parent= null;
        //被删结点左右结点都不为空
        if (find.left != null && find.right != null) {
            //找到要删除结点的右子树中的最小值  //也可以是左子树中的最大值  这里选择右子树中的最小值
            temp = find.right;
            parent = find;
            //最小值一定在左子树
            while (temp.left != null) {
                parent = temp;
                temp = temp.left;
            }
            parent.val = temp.val;
            find = temp;
        }

        //待删结点的右子树的最小值结点结点成为待删结点
        //只有左结点或右结点 并且记录子结点
        if (find.left != null) {
            temp = find.left;
        } else {
            temp = find.right;
        }

        //被删结点是根结点
        if (find == root) {
            root = temp;
        } else if (temp != null && temp.val < parent.val) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
    }

    public BSTNode search(int val) {
        BSTNode node = root;
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

    private void preOrder(BSTNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }
}

class BSTNode {
    BSTNode left;
    BSTNode right;
    int val;

    public BSTNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                '}';
    }
}
