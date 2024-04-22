package com.gzq.demo.leetcode.数组.两数之和II输入有序数组;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] dp = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int left = i;
            int right = left + 1;
            while (right < numbers.length) {
                if (numbers[left] + numbers[right] == target) {
                    dp[0] = left + 1;
                    dp[1] = right + 1;
                    return dp;
                } else if (numbers[left] + numbers[right] < target) {
                    right++;
                }else{
                    break;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
    }
}
