package com.yiqiandewo.dynamicprogramming;

import java.util.Arrays;

/**
 * 0 1背包
 */
public class Package01 {
    public static void main(String[] args) {
        int[] w = {2, 3, 4, 5, 9};
        int[] v = {3, 4, 6, 8, 10};
        int res = solve(w, v, 20);
        System.out.println(res);
    }

    //w是重量 v是价值 W是最大容量
    public static int solve(int[] w, int[] v, int W) {
        //dp[i][j]代表将前i个物品放入容量为j的背包的最大价值
        int[][] dp = new int[w.length][W+1];

        for (int i = 0; i <= W; i++) {
            dp[0][i] = (w[0] <= i) ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= W; j++) {
                //容量不足以放下第i个物品
                dp[i][j] = dp[i -1][j];
                if (w[i] <= j) {
                    //容量足够
                    dp[i][j] = Math.max(dp[i][j], (dp[i - 1][j - w[i]] + v[i]));
                }
            }
        }

        return dp[w.length-1][W];
    }
}
