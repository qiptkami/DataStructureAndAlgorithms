package com.yiqiandewo.recursion;

public class EightQueens {

    private int count;

    public static void main(String[] args) {
        int[][] chess = new int[8][8];

        EightQueens eightQueens = new EightQueens();
        eightQueens.eightQueen(chess, 0);
    }

    private void print(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean notDanger(int[][] chess, int row, int col) {
        // 判断列方向
        for(int i = 0; i < 8; i++) {
            if (chess[i][col] == 1) {
                return false;
            }
        }
        // 判断左对角线
        for(int i = row, k = col; i >= 0 && k >= 0; i--, k--) {
            if (chess[i][k] == 1) {
                return false;
            }
        }
        // 判断右对角线
        for(int i = row, k = col; i >= 0 && k < 8; i--, k++ ) {
            if (chess[i][k] == 1) {
                return false;
            }
        }
        return true;
    }

    private void eightQueen(int[][] chess, int row) {
        if (row > 7) {
            count++;
            System.out.println("第" + count + "种解法");;
            print(chess);
            return;
        }
        int col;
        for (col = 0; col < 8; col++) {
            if (notDanger(chess ,row ,col)) {
                chess[row][col] = 1;

                eightQueen(chess, row+1);

                chess[row][col] = 0;
            }
        }
    }

}
