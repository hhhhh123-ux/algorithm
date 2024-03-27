package com.gzq.demo.leetcode.数组.最接近的三数之和;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int absoluteDifference = Math.abs(sum - target);
                    hashMap.put(absoluteDifference, sum);
                    min = Math.min(min, absoluteDifference);
                }
            }
        }
        return hashMap.get(min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}

