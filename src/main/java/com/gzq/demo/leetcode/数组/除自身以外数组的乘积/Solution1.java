package com.gzq.demo.leetcode.数组.除自身以外数组的乘积;

import java.util.TreeMap;

public class Solution1 {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                answer[i] = map.get(nums[i]);
                continue;
            }
            answer[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    answer[i] *= nums[j];
                }
            }
            map.put(nums[i], answer[i]);
        }
        return answer;
    }

}
