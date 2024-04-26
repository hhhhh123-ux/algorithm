package com.gzq.demo.leetcode.数组.打家劫舍II;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                dp2[i-1] = Math.max(nums[i], dp2[i - 2]);
            } else {
                dp2[i-1] = Math.max(dp2[i - 2], dp2[i - 3] + nums[i]);
            }
        }
        return dp[nums.length - 2] > dp2[nums.length - 2] ? dp[nums.length - 2] : dp2[nums.length - 2];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1,2}));
    }
}
