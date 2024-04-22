package com.gzq.demo.leetcode.数组.轮转数组;

import java.util.Arrays;

public class Solution1 {

    public void rotate(int[] nums, int k) {

        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution1().rotate(new int[]{1, 2}, 3);
    }
}
