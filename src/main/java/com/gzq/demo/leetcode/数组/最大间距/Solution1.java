package com.gzq.demo.leetcode.数组.最大间距;

import java.util.Arrays;

public class Solution1 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maximumGap(new int[]{0, 1}));
    }
}
