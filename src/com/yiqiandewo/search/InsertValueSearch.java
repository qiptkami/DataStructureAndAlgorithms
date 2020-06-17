package com.yiqiandewo.search;

/**
 * 插值查找
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 15, 31, 42, 45, 56, 876, 1234};

        int index = insertValueSearch(arr, 876);

        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        if (value < arr[low] || value > arr[high]) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) * (value - arr[low]) / (arr[high] - arr[low]);
            if (mid > arr[arr.length-1]) {
                return -1;
            }

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
