package com.yiqiandewo.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    //LSD
    public static void radixSort(int[] arr) {
        int max = max(arr);  //数组中最大数的位数 代表循环几次
        int num = 1;   //为求出每个数的每一位
        for (int i = 0; i < max; i++) {
            int[][] bucket = new int[10][arr.length];  //用一个二位数组来表示桶
            int[] counts = new int[10];   //表示每个桶中存放了多少个数字

            //根据每位上的数字将每个数分配到桶中
            for (int j = 0; j < arr.length; j++) {
                //k是位数上的数字 代表在第几个桶
                int k = arr[j] / num;
                k %= 10;
                counts[k]++;
                bucket[k][counts[k]-1] = arr[j];
            }

            int index = 0;
            //根据桶中的顺序 到数组中
            for (int j = 0; j < arr.length; j++) {
                //判断每个桶中是否有数字 即counts[j]!=0
                if (counts[j] != 0) {
                    //从桶中取出数字
                    for (int k = 0; k < counts[j]; k++) {
                        if (bucket[j][k] != 0) {
                            arr[index++] = bucket[j][k];
                        }
                    }
                }
            }

            num *= 10;
        }
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int index = 0;

        while (max > 0) {
            max = max / 10;
            index++;
        }
        return index;
    }
}
