package com.gzq.demo.leetcode.数组.打家劫舍;

public class Solution {


    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,1,1}));
    }
}
