package com.yiqiandewo.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 15, 31, 42, 45, 56, 876, 1234};

        //int index = binarySearchRec(arr, 0, arr.length - 1, 31);
        int index = binarySearchCycle(arr, 1234);

        System.out.println(index);
    }

    //递归
    public static int binarySearchRec(int[] arr, int low, int high,int value) {
        if (value < arr[low] || value > arr[high] || low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] < value) { //如果value比中值大  说明在mid的右边
            binarySearchRec(arr, mid + 1, high, value);
        } else if (arr[mid] > value) {  //value比中值小 在mid左边
            binarySearchRec(arr, low, mid - 1, value);
        } else {
            return mid;
        }
        return -1;
    }

    public static int binarySearchCycle(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        if (value < arr[low] || value > arr[high]) {
            return -1;
        }

        while (low <= high) {
            int mid = (low  + high) / 2;
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
