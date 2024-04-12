package com.gzq.demo.leetcode.动态规划.买卖股票的最佳时机III;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][j][0] 表示第i天第j次交易结束，未持有股票的最大利润
        // dp[i][j][1] 表示第i天第j次交易结束，持有股票的最大利润
        // j=0 表示未交易
        // j=1 表示第一次交易
        // j=2 表示第二次交易
        int[][][] dp = new int[len][3][2];
        // 理解如下初始化
        // 第 3 维规定了必须持股，因此是 -prices[0]
        dp[0][1][1] = -prices[0];
        // 还没发生的交易，持股的时候应该初始化为负无穷
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < 3; j++) {
                // 第 0 天，第 j 次交易结束，未持有股票的最大利润
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 第 0 天，第 j 次交易结束，持有股票的最大利润
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
