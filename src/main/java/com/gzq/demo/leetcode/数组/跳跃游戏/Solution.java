package com.gzq.demo.leetcode.数组.跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= n) {
                    return dp[n - 1];
                }
                if (dp[i]) {
                    dp[i + j] = dp[i];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{0, 2, 3}));
    }
}
