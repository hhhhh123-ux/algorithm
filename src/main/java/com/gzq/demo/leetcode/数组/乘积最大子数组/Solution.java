package com.gzq.demo.leetcode.数组.乘积最大子数组;


import java.util.Arrays;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i] = 0;
            } else if (nums[i] > 0) {
                if (dp[i - 1] == 0) {
                    dp[i] = nums[i];
                } else if (dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
                }
            } else {
                if (dp[i - 1] == 0) {
                    dp[i] = nums[i];
                } else if (dp[i - 1] > 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{-2, 3, -4}));
    }
}
