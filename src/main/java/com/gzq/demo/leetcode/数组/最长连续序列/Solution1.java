package com.gzq.demo.leetcode.数组.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestStreak = 0;
        for (int num : set) {
            // 如果当前数字的前一个数字不存在于集合中，则当前数字为连续序列的起点
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 循环查找连续序列的长度
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
