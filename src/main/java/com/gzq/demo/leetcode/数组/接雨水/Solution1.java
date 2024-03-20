package com.gzq.demo.leetcode.数组.接雨水;


public class Solution1 {
    public int trap(int[] height) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int leftMax = getStartMax(i, height, height[i]);
            int endMax = getEndMax(i, height, height[i]);
            dp[i] = dp[i - 1] + Math.max(height[i], Math.min(leftMax, endMax)) - height[i];
        }
        return dp[height.length - 1];
    }

    public int getStartMax(int i, int[] height, int height2) {
        int maxValue = Integer.MIN_VALUE;
        for (int j = 0; j < height.length && j < i; j++) {
            maxValue = Math.max(maxValue, height[j]);
        }
        if (maxValue > height2) {
            return maxValue;
        } else {
            return 0;
        }
    }

    public int getEndMax(int i, int[] height, int height2) {
        int maxValue = Integer.MIN_VALUE;
        for (int j = i + 1; j < height.length; j++) {
            maxValue = Math.max(maxValue, height[j]);
        }
        if (maxValue > height2) {
            return maxValue;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new Solution1().trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("=="+elapsedTime);
    }
}
