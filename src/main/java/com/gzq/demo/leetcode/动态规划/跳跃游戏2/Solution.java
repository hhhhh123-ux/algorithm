package com.gzq.demo.leetcode.动态规划.跳跃游戏2;

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
            dp[i] = n + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                if (i + j >= n) {
                    return dp[n - 1];
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }


}
