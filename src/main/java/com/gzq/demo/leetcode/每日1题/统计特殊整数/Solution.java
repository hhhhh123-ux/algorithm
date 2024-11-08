package com.gzq.demo.leetcode.每日1题.统计特殊整数;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSpecialNumbers(135));
    }

    public int countSpecialNumbers(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            HashSet<Character> seenDigits = new HashSet<>();
            String numberStr = String.valueOf(i); // 将数字转换为字符串
            boolean hasDuplicate = false;
            // 遍历每一位数字
            for (char digit : numberStr.toCharArray()) {
                if (seenDigits.contains(digit)) {
                    hasDuplicate = true; // 如果已经遇到过该数字，说明有重复
                    break;
                }
                seenDigits.add(digit); // 记录已经遇到的数字
            }

            // 输出是否有重复
            if (!hasDuplicate) {
                count++;
            }
        }
        return count;
    }
}
