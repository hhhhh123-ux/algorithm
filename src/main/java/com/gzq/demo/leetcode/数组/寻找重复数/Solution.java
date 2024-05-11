package com.gzq.demo.leetcode.数组.寻找重复数;

import java.util.HashMap;

public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
