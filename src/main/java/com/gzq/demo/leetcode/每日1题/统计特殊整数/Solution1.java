package com.gzq.demo.leetcode.每日1题.统计特殊整数;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.countSpecialNumbers(100);
        System.out.println("没有重复数字的数量: " + result);
    }

    public int countSpecialNumbers(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!hasDuplicateDigits(i)) {
                count++; // 统计没有重复数字的数
            }
        }
        return count;
    }

    // 使用位运算检查是否有重复数字
    private boolean hasDuplicateDigits(int number) {
        int seenDigits = 0;
        while (number > 0) {
            int digit = number % 10; // 提取最后一位数字
            // 如果该数字已经在 seenDigits 中，则说明有重复
            if ((seenDigits & (1 << digit)) != 0) {
                return true;
            }
            // 标记该数字
            seenDigits |= (1 << digit);
            number /= 10; // 去掉最后一位数字
        }
        return false; // 没有重复数字
    }
}
