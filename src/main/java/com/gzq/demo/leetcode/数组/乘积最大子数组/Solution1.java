package com.gzq.demo.leetcode.数组.乘积最大子数组;

import java.util.Arrays;

public class Solution1 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
        } else if (nums[0] < 0) {
            dp[0][1] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));
        }
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = dp[i][0];
        }
        Arrays.sort(data);
        return data[data.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProduct(new int[]{-2}));
    }
}
