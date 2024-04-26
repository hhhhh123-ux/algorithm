package com.gzq.demo.leetcode.数组.除自身以外数组的乘积;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    answer[i] *= nums[j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
