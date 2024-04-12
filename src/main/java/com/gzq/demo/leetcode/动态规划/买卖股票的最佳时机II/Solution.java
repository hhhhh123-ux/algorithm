package com.gzq.demo.leetcode.动态规划.买卖股票的最佳时机II;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                int temp = prices[i] - prices[i - 1];
                if (temp > 0) {
                    dp[i] = dp[i - 1] + temp;
                }else {
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
    }
}
