package com.yiqiandewo.topk;

/**
 * 找出给定数组中第k大的数
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        TopK topK = new TopK();
        System.out.println(topK.findKthLargest(arr, 4));
    }

    public int findKthLargest(int[] arr, int k) {
        return quickSelect(arr, k - 1, 0, arr.length - 1);
    }


    public int topK(int[] arr, int k) {
        buildHeap(arr);

        for (int i = arr.length - 1; i > arr.length - k; i--) {
            //第一个节点和最后一个节点交换
            swap(arr, 0, i);
            //当前堆被破坏，重新构造堆
            heapify(arr, 0, i);
        }

        return arr[0];
    }


    private void buildHeap(int[] arr) {
        //首先找到最后一下父节点
        int parent = (arr.length - 1) / 2;

        //自底向上构建堆
        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private void heapify(int[] arr, int i, int len) { //i是parent节点的下标, len是要对多少个节点构建堆
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < len && arr[max] < arr[left]) {
            max = left;
        }

        if (right < len && arr[max] < arr[right]) {
            max = right;
        }

        if (max != i) {
            swap(arr, max, i);

            //对被破坏的子树重新构建大顶堆
            heapify(arr, max, len);
        }
    }

    private int quickSelect(int[] arr, int k, int left, int right) {
        int res = partition(arr, left, right);
        if (res == k) {
            return arr[k];
        }

        return res > k ? quickSelect(arr, k, left, res - 1) : quickSelect(arr, k, res + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = right;
        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, j);
                j++;
            }
        }

        swap(arr, j, pivot);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
