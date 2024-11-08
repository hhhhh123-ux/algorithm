package com.gzq.demo.leetcode.每日1题.数组元素和与数字和的绝对差;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().differenceOfSum(new int[]{1, 15, 6, 3}));
    }

    public int differenceOfSum(int[] nums) {

        int sum = 0;
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < nums.length; i++) {
            sumA += nums[i];
            String str = String.valueOf(nums[i]);
            for (char c : str.toCharArray()) {
                // 对每个字符进行具体的处理逻辑
                sumB+=Integer.valueOf(c) - '0';
            }

        }
        return sumA - sumB > 0? sumA - sumB : sumB - sumA;
    }
}
