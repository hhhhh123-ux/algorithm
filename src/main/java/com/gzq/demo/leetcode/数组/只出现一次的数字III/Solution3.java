package com.gzq.demo.leetcode.数组.只出现一次的数字III;

import java.util.Arrays;

public class Solution3 {
    public int[] singleNumber(int[] nums) {
        // 第一次异或得到两个只出现一次的数字的异或结果
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 找到结果中某位为 1 的位置，可以任意选择
        int bit = 1;
        while ((xor & bit) == 0) {
            bit <<= 1;
        }
        // 将数组中的数字按照该位是否为 1 分成两组，分别进行异或运算
        int result1 = 0;
        int result2 = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }
        return new int[]{result1, result2};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
