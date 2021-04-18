package com.yiqiandewo.sort;

import java.util.Arrays;

/**
 * 每趟选择最小的数 才交换
 * O(n²)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }

        }
    }
}
