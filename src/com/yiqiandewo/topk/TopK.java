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
