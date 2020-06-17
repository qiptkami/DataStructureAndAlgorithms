package com.yiqiandewo.unionfind;

/**
 * 该代码的find方法十分高效  因为仅仅需要一次数组读取操作就能够找到该节点的组号
 * 但是问题随之而来  对于需要添加新路径的情况  就涉及到对于组号的修改
 * 因为并不能确定哪些节点的组号需要被修改  因此就必须对整个数组进行遍历
 * 找到需要修改的节点  逐一修改  这一下每次添加新路径带来的复杂度就是线性关系了
 * 如果要添加的新路径的数量是M  节点数量是N  那么最后的时间复杂度就是MN  显然是一个平方阶的复杂度
 * 对于大规模的数据而言  平方阶的算法是存在问题的  这种情况下  每次添加新路径就是“牵一发而动全身”
 * 想要解决这个问题  关键就是要提高union方法的效率  让它不再需要遍历整个数组
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

}
