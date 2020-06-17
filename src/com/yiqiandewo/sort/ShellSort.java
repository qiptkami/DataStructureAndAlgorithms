package com.yiqiandewo.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15, 2189, 1, 2, 3, 234};

//        shellSortSwap(arr);

        shellSortMove(arr);

        System.out.println(Arrays.toString(arr));
    }

    //交换
    public static void shellSortSwap(int[] arr) {
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }

            }
        }
    }

    //移位
    public static void shellSortMove(int[] arr) {
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                while (i - gap >= 0 && key < arr[i-gap]) {
                    arr[i] = arr[i-gap];
                    i -= gap;
                }
                arr[i] = key;
            }
        }
        
    }

}
