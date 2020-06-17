package com.yiqiandewo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    public static void merge(int[] arr, int left, int m, int right) {
        int[] leftArr = new int[m - left + 1];
        int[] rightArr = new int[right - m];
        for (int i = left; i <= m; i++) {
            leftArr[i-left]  = arr[i];
        }

        for (int i = m + 1; i <= right; i++) {
            rightArr[i-m-1] = arr[i];
        }

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        } else {
            //分治 先分后治
            int m = (left+right) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m+1, right);
            merge(arr, left, m, right);
        }
    }
}
