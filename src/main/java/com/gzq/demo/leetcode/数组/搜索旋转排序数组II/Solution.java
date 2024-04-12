package com.gzq.demo.leetcode.数组.搜索旋转排序数组II;

import java.util.Arrays;

public class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }
}
