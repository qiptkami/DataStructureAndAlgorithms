package com.yiqiandewo.sparsearray;

/**
 * 全排列
 */
public class FullPermutation {

    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        int[] arr = {1, 2, 3};
        fullPermutation.perm(arr, 0, 2);
    }


    private void perm(int[] arr, int left, int right) {

        if (right == left) {
            printArr(arr);
        }

        for (int i = left; i <= right; i++) {
            swap(arr, left, i);
            perm(arr, left+1, right);
            swap(arr, left, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
