package com.gzq.demo.leetcode.数组.最接近的三数之和;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            while (left < i && i < right) {
                int sum = nums[left] + nums[i] + nums[right];
                int absoluteDifference = Math.abs(sum - target);
                if (absoluteDifference==0) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
                hashMap.put(absoluteDifference, sum);
            }
        }
        Integer minKey = Collections.min(hashMap.keySet());
        return hashMap.get(minKey);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }
}
