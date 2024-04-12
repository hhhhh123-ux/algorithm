package com.gzq.demo.leetcode.动态规划.买卖股票的最佳时机;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int temp = prices[0];
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                temp = Math.min(temp, prices[i]);
                dp[i] = prices[i] - temp;
            }
        }
        Arrays.sort(dp);
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
