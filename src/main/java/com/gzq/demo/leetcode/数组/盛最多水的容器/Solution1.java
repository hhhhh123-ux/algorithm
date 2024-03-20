package com.gzq.demo.leetcode.数组.盛最多水的容器;

public class Solution1 {
    public int maxArea(int[] height) {

        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                dp[i] = Math.max(dp[i], (j - i) * Math.min(height[i], height[j]));

            }
        }
        int area = getMax(dp);
        return area;
    }

    public int getMax(int[] dp) {
        if (dp == null || dp.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int max = dp[0]; // 假设第一个元素是最大值

        // 遍历数组并更新最大值
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
