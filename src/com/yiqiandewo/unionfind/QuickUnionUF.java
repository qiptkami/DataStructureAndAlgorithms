package com.yiqiandewo.unionfind;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //回溯找到父节点
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return  i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //连通q和p的root
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }
}
