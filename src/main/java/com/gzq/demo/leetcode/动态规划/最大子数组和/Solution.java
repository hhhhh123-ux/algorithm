package com.gzq.demo.leetcode.动态规划.最大子数组和;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
        }
        int max = dp[0];  // 假设第一个元素是最大值
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];  // 更新最大值
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
