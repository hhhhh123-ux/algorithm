package com.gzq.demo.leetcode.数组.只出现一次的数字II;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 3, 2}));
    }
}
