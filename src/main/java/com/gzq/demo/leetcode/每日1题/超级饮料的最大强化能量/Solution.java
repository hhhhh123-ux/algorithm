package com.gzq.demo.leetcode.每日1题.超级饮料的最大强化能量;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + energyDrinkA[i - 1];
            dp[i][1] = dp[i - 1][1] + energyDrinkB[i - 1];
            if (i >= 2) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][1] + energyDrinkA[i - 1]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 2][0] + energyDrinkB[i - 1]);
            }
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}
