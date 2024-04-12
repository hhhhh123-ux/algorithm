package com.gzq.demo.leetcode.数组.最长连续序列;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int maxValue = 0;
        if (nums.length == 0) {
            return maxValue;
        }
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        maxValue = 1;
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                map.put(nums[i], map.get(nums[i - 1]) + 1);
            } else if (nums[i] == nums[i - 1]) {
                if (map.get(nums[i - 1]) > 1) {
                    map.put(nums[i], map.get(nums[i - 1]));
                } else {
                    map.put(nums[i], 1);
                }
            } else {
                map.put(nums[i], 1);
            }
            maxValue = Math.max(maxValue, map.get(nums[i]));
        }
        if (map.size() > 0) {
            return maxValue;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{1}));
    }
}
