package com.gzq.demo.leetcode.数组.三数之和;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                        Integer max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                        list.add(min);
                        if ((nums[i] == min && nums[j] == max) || (nums[i] == max && nums[j] == min)) {
                            list.add(nums[k]);
                        } else if ((nums[i] == min && nums[k] == max) || nums[i] == max && nums[k] == min) {
                            list.add(nums[j]);
                        } else if ((nums[j] == min && nums[k] == max) || (nums[j] == max && nums[k] == min)) {
                            list.add(nums[i]);
                        }
                        list.add(max);
                        lists.add(list);
                    }
                }
            }
        }
        List<List<Integer>> listss = lists.stream()
                .distinct() // 去除重复的列表
                .collect(Collectors.toList());
        return listss;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


}
