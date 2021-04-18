package com.yiqiandewo.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15, 2189, 1, 2, 3, 234};
        shellSortSwap(arr);

        //shellSortMove(arr);
        System.out.println(Arrays.toString(arr));
    }

    //交换
    public static void shellSortSwap(int[] arr) {
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) { //增量gap，并逐步缩小增量
            for (int i = gap; i < arr.length; i++) {  //从第gap个元素，逐个对其所在组进行直接插入排序操作
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j-gap]) {
                    //插入排序采用交换法
                    int temp = arr[j];
                    arr[j] = arr[j+gap];
                    arr[j+gap] = temp;
                    j -= gap;
                }
            }
        }
    }

    //移位
    public static void shellSortMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = i;
                int key = arr[i];
                while (temp - gap >= 0 && key < arr[temp-gap]) {
                    arr[temp] = arr[temp-gap];
                    temp -= gap;
                }
                arr[temp] = key;
            }
        }
    }

}
