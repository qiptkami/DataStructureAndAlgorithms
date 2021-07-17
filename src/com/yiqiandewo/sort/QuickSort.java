package com.yiqiandewo.sort;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        int[] arr = new int[] {8, 5, 1, 6, 2, 7, 3, 4};
        //quickSort(arr, 0, arr.length - 1);
        stackQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid =  partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;

            }
        }

        int temp = arr[right];
        arr[right] = arr[j];
        arr[j] = temp;
        return j;
    }

    //快速排序的非递归实现
    public static void stackQuickSort(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();

        stack.addLast(arr.length - 1);
        stack.addLast(0);

        while (!stack.isEmpty()) {
            int left = stack.pollLast();
            int right = stack.pollLast();

            if (left > right) {
                continue;
            }

            int m = partition(arr, left, right);

            //右区间
            stack.addLast(right);
            stack.addLast(m + 1);

            //左区间
            stack.addLast(m - 1);
            stack.addLast(left);
        }

    }

}
