package com.gzq.demo.leetcode.数组.颜色分类;

import java.util.Arrays;

public class Solution1 {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        new Solution1().sortColors(nums);
    }
}
