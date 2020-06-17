package com.yiqiandewo.sort;

import java.util.Arrays;

/**
 * 插入排序思想是将一个元素插入到已经排好序的数组中，从而形成一个新的的有序数组
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            while (i > 0 && (arr[i-1] > key)) {
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = key;
        }
    }
}
