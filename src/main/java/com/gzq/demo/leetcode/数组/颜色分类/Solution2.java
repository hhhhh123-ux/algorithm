package com.gzq.demo.leetcode.数组.颜色分类;

import java.util.Arrays;

public class Solution2 {
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        int index = 0;
        while (begin < end) {

        }
        System.out.println(Arrays.toString(nums));
    }

    public Boolean validate(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution2().sortColors(new int[]{1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0});
    }
}
