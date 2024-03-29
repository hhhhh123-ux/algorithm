package com.gzq.demo.leetcode.数组.三数之和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<>();
        int kk;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = nums.length - 1; k > j; k--) {
                    kk = -nums[i] - nums[j];
                    if (kk > nums[k]) {
                        break;
                    } else {
                        if (kk == nums[k]) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list);
                        }
                    }
                }
            }
        }
        lists = lists.stream()
                .distinct().collect(Collectors.toList());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
