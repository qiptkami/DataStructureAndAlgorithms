package com.yiqiandewo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        quickSort(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));

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
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int M =  partition(arr, left, right);
            quickSort(arr, left, M-1);
            quickSort(arr, M+1, right);
        }

    }
}
