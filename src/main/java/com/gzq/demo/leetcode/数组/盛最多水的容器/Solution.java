package com.gzq.demo.leetcode.数组.盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = height.length / 2; i > 0; i--) {
            for (int j = height.length / 2; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,1}));
    }
}
