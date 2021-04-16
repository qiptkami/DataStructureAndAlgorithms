package com.yiqiandewo.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换根节点个最后一个结点的值
            swap(arr, 0, i);
            //交换了会破坏堆
            heapify(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        //从下向上构建堆
        int parent = (arr.length - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    /**
     * 数组堆化
     * 当下标从0开始
     *         i结点的左节点为 2*i+1
     *         i结点的右节点为 2*i+2
     *         i结点的父节点为 (i-1)/2
     * @param arr
     * @param i    要对第i个结点heapify
     * @param len  每个heapify的数组的大小
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        //找出该二叉树中最大的结点 让它成为父节点
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }

        //如果当前父节点已经是最大的话 说明当前二叉树已经是堆了
        if (max != i) {
            swap(arr, i, max);
            //对一个节点做heapify的时候  必须保证它的所有子树都已经是堆
            heapify(arr, max, len);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
