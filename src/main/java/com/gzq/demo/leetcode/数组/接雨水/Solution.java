package com.gzq.demo.leetcode.数组.接雨水;

public class Solution {

    private int ii = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{10, 1, 4, 4, 6}));
    }

    public int trap(int[] height) {
        int[] dp = new int[height.length];
        int begin = 0;
        int beginMax = 0;
        int endMax = 0;
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (i == height.length - 1) {
                dp[i] = dp[i - 1];
                return dp[height.length - 1];
            }
            if (height[i] < height[i - 1] && height[i] < height[i + 1]) {
                if (begin != 0) {
                    dp[i] = dp[i - 1] + Math.max(height[i], beginMax) - height[i];
                    begin++;
                } else {
                    int b = getMaxValue(i, height, height[i]);
                    if (b != 0) {
                        dp[i] = dp[i - 1] + Math.min(b, height[i - 1]) - height[i];
                    } else {
                        dp[i] = dp[i - 1] + Math.min(height[i - 1], height[i + 1]) - height[i];
                    }
                }
            } else if (height[i - 1] > height[i] && height[i] >= height[i + 1]) {
                endMax = Math.max(endMax, height[i - 1]);
                int b = getMaxValue(i, height, height[i]);
                if (b != 0) {
                    dp[i] = dp[i - 1] + Math.min(Math.max(endMax, height[i]), b) - height[i];
                    beginMax = Math.min(Math.max(endMax, height[i]), b);
                    begin++;
                } else {
                    dp[i] = dp[i - 1];
                }
            } else if (height[i - 1] <= height[i] && height[i] < height[i + 1]) {
                if (begin != 0) {
                    dp[i] = dp[i - 1] + beginMax - height[i];
                } else {
                    int b = getMaxValue(i, height, height[i]);
                    if (b != 0) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + Math.max(height[i], height[i + 1]) - height[i];
                    }

                }
            } else if (height[i] > height[i - 1] && height[i] > height[i + 1]) {
                if (begin != 0) {
                    if (i == ii) {
                        dp[i] = dp[i - 1];
                        beginMax = 0;
                        begin = 0;
                    } else if (height[i] > endMax) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + beginMax - height[i];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }


        }
        return dp[height.length - 1];
    }

    public int getMaxValue(int i, int[] height, int height2) {
        int maxValue = Integer.MIN_VALUE;
        for (int j = i + 1; j < height.length; j++) {
            maxValue = Math.max(maxValue, height[j]);
        }
        for (int j = i + 1; j < height.length; j++) {
            if (height[j] == maxValue) {
                ii = j;
            }
        }
        if (maxValue > height2) {
            return maxValue;
        } else {
            return 0;
        }
    }
}
