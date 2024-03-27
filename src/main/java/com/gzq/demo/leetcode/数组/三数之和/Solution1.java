package com.gzq.demo.leetcode.数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<>();

        for (int j = 1; j < nums.length; j++) {
            int left = 0;
            int right = nums.length - 1;
            while (left < j && right > j) {
                if (nums[left] + nums[j] + nums[right] == 0) {
                    lists.add(Arrays.asList(nums[left], nums[j], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[j] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        lists = lists.stream()
                .distinct().collect(Collectors.toList());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
