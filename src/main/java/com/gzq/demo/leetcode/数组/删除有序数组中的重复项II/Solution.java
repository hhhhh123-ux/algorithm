package com.gzq.demo.leetcode.数组.删除有序数组中的重复项II;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (treeMap.getOrDefault(nums[i], 0) < 2) {
                treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        if (treeMap.size() > 0) {
            int i = 0;
            int m = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                for (int j = 0; j < entry.getValue(); j++) {
                    nums[m+j] = entry.getKey();
                    i++;
                }
                m += entry.getValue();
            }
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
