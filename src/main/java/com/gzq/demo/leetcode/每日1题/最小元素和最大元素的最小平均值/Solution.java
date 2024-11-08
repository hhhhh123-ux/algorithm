package com.gzq.demo.leetcode.每日1题.最小元素和最大元素的最小平均值;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }

    public double minimumAverage(int[] nums) {
        double average = Double.MAX_VALUE;
        Arrays.sort(nums);
        int count = nums.length / 2;
        for (int i = 0; i < count; i++) {
            int minElement = nums[i];
            int maxElement = nums[nums.length - 1 - i];
            average = Math.min(average, Double.valueOf(maxElement + minElement) / 2);
        }
        return average;
    }
}
