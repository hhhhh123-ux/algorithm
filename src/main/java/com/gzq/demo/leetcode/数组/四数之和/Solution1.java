package com.gzq.demo.leetcode.数组.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<>();
        for (int b = 1; b < nums.length; b++) {
            for (int c = b + 1; c < nums.length; c++) {
                int left = 0;
                int right = nums.length - 1;
                while (left < b && right > c) {
                    if (Long.valueOf(nums[left]) + Long.valueOf(nums[b]) + Long.valueOf(nums[c]) + Long.valueOf(nums[right]) == Long.valueOf(target)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[right]);
                        lists.add(list);
                        left++;
                        right--;
                    } else if (Long.valueOf(nums[left]) + Long.valueOf(nums[b]) + Long.valueOf(nums[c]) + Long.valueOf(nums[right]) < Long.valueOf(target)) {
                        left++;
                    } else if (Long.valueOf(nums[left]) + Long.valueOf(nums[b]) + Long.valueOf(nums[c]) + Long.valueOf(nums[right]) > Long.valueOf(target)) {
                        right--;
                    }
                }
            }
        }
        lists = lists.stream().distinct().collect(Collectors.toList());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000));
    }
}
