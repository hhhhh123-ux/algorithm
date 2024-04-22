package com.gzq.demo.leetcode.数组.最大间距;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] - nums[i - 1];
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumGap(new int[]{0,1}));
    }
}
