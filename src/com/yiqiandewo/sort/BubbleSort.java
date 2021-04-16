package com.yiqiandewo.sort;

import java.util.Arrays;

/**
 * 冒泡排序的思想，我们要把相邻的元素两两比较，根据大小来交换元素的位置
 * 相邻的两个元素冒泡
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 45, 12, 56, 1, 876, 31, 1234, 42, 15};

        //bubbleSort(arr);
        cocktailSort(arr);

        System.out.print(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int k = arr.length - 1;
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            int pos = 0; //用来记录最后一次比较的位置
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                    pos = j;
                }
            }
            if (!flag) {
                //如果flag仍然未false 则说明某一趟未交换
                return;
            }
            k = pos;  //下一次只需比较到记录位置
        }
    }

    //鸡尾酒排序(Cocktail Sort)
    //又名：双向冒泡排序 (Bidirectional Bubble Sort)、波浪排序 (Ripple Sort)、
    //     摇曳排序 (Shuffle Sort)、飞梭排序 (Shuttle Sort) 和欢乐时光排序 (Happy Hour Sort))
    public static void cocktailSort(int[] arr) {
        int left = 0;
        int right =  arr.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }

            //因为上面是从左往右冒泡 所以right一定是有序的 所以先right--
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }

            left++;

        }
    }
}
