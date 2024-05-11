package com.gzq.demo.leetcode.数组.只出现一次的数字III;

import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int[] result = new int[2];
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            if (nums[begin] != nums[begin + 1]) {
                result[xor] = nums[begin];
                xor++;
                begin++;
            } else if (nums[begin] == nums[begin + 1]) {
                begin = begin + 2;
            }
        }
        if (begin == end) {
            result[xor] = nums[end];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
