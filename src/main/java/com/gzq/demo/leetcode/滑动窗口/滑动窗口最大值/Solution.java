package com.gzq.demo.leetcode.滑动窗口.滑动窗口最大值;

import java.util.Arrays;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i]=getMaxValue(nums, i, k);
        }
        return result;
    }

    public int getMaxValue(int[] nums,int i, int k) {
        int max = nums[i];
        for (int j = i; j < i + k; j++) {
            if (nums[j] > max) {
                max = nums[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
