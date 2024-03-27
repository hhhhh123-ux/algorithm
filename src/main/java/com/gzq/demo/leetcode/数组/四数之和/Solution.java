package com.gzq.demo.leetcode.数组.四数之和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(nums[a]);
                            list1.add(nums[b]);
                            list1.add(nums[c]);
                            list1.add(nums[d]);
                            list.add(list1);
                        }
                    }
                }
            }
        }
        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
