package com.gzq.demo.leetcode.数组.删除有序数组中的重复项II;

import java.util.Arrays;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
