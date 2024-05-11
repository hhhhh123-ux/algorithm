package com.gzq.demo.leetcode.数组.只出现一次的数字III;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution1 {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] singleNumber(int[] nums) {
        int asn = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                result[asn] = key;
                asn++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
