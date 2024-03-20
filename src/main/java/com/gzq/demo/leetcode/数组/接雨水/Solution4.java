package com.gzq.demo.leetcode.数组.接雨水;

public class Solution4 {

    public static int leftMax = 0;
    public static int rightMax = 0;

    public int trap(int[] height) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            getStartMax(i, height, height[i]);
            getEndMax(i, height, height[i]);
            dp[i] = dp[i - 1] + Math.max(height[i], Math.min(leftMax, rightMax)) - height[i];
        }
        return dp[height.length - 1];
    }

    public void getStartMax(int i, int[] height, int height2) {
        if (leftMax != 0) {
            leftMax = Math.max(leftMax, height[i - 1]);
        } else {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < height.length && j < i; j++) {
                maxValue = Math.max(maxValue, height[j]);
            }
            if (maxValue > height2) {
                leftMax = maxValue;
            } else {
                leftMax = 0;
            }
        }
    }

    public void getEndMax(int i, int[] height, int height2) {
        if (rightMax != 0) {
            if (height[i] < rightMax) {
                rightMax = rightMax;
            } else if (height[i] >= rightMax) {
                rightMax = 0;
                getEndMax(i, height, height2);
            }
        } else {
            int maxValue = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length; j++) {
                maxValue = Math.max(maxValue, height[j]);
            }
            if (maxValue > height2) {
                rightMax = maxValue;
            } else {
                rightMax = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
    }
}
