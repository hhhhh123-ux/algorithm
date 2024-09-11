package com.gzq.demo.leetcode.数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int k;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                k = 0 - nums[i] - nums[j];
                if (Arrays.asList(nums).contains(k)) {

                }
            }
        }
        List<List<Integer>> listss = lists.stream()
                .distinct() // 去除重复的列表
                .collect(Collectors.toList());
        return listss;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
