package com.gzq.demo.leetcode.动态规划.买卖股票的最佳时机IV;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // dp[i][j][0] 表示第i天第j次交易结束，未持有股票的最大利润
        // dp[i][j][1] 表示第i天第j次交易结束，持有股票的最大利润
        // j=0 表示未交易
        // j=1 表示第一次交易
        // j=2 表示第二次交易
        int[][][] dp = new int[len][k + 1][2];
        // 理解如下初始化
        // 第 3 维规定了必须持股，因此是 -prices[0]
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j == 1) {
                    dp[0][1][1] = -prices[0];
                }
                // 还没发生的交易，持股的时候应该初始化为负无穷
                if (j > 1) {
                    dp[0][j][1] = Integer.MIN_VALUE;
                }
                // 第 0 天，第 j 次交易结束，未持有股票的最大利润
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 第 0 天，第 j 次交易结束，持有股票的最大利润
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        int[][] max = dp[len - 1];
        int[] maxValues = new int[max.length];
        for (int i = 0; i < max.length; i++) {
            maxValues[i] = max[i][0];
        }
        // maxValues 数组中存储了所有 max[i][0] 的值
        Arrays.sort(maxValues);
        return maxValues[maxValues.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(4, new int[]{5, 7, 2, 7, 3, 3, 5, 3, 0}));
    }
}
