package com.yiqiandewo.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[2][3] = 34;
        arr[4][6] = 53;
        arr[6][9] = 21;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }

        //稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                System.out.print(sparseArr[i][j] + " ");
            }
            System.out.println();
        }

        int[][] arr_new = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <= sparseArr[0][2]; i++) {
            arr_new[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int i = 0; i < arr_new.length; i++) {
            for (int j = 0; j < arr_new[0].length; j++) {
                System.out.print(arr_new[i][j] + " ");
            }
            System.out.println();
        }
    }
}
