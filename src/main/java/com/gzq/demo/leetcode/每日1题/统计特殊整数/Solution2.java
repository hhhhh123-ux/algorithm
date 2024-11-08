package com.gzq.demo.leetcode.每日1题.统计特殊整数;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int n = 62850183;  // 示例数字范围
        int result = solution.countSpecialNumbers(n);
        System.out.println("没有重复数字的数量: " + result);
    }

    // 计算没有重复数字的数量
    public int countSpecialNumbers(int n) {
        if (n < 10) {
            return n;  // 如果 n 小于 10，所有数字都不重复
        }

        // 将 n 转换为字符数组，方便逐位处理
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int count = 0;

        // 计算小于 n 的长度为 (1 到 len - 1) 的数字组合
        for (int i = 1; i < len; i++) {
            count += countUniqueDigits(i); // 长度为 i 的无重复数字的数
        }

        // 计算与 n 等长且小于等于 n 的无重复数字的数量
        count += countUniqueDigitsUpToN(digits);

        return count;
    }

    // 计算长度为 n 的无重复数字的数量
    private int countUniqueDigits(int n) {
        int count = 9; // 第一位不能是 0
        int available = 9; // 剩下的可用数字
        for (int i = 1; i < n; i++) {
            count *= available; // 每一位可以选的数字逐渐减少
            available--;
        }
        return count;
    }

    // 计算与 n 位数等长且小于等于 n 的无重复数字的数量
    private int countUniqueDigitsUpToN(char[] digits) {
        int len = digits.length;
        int count = 0;
        boolean[] used = new boolean[10]; // 标记数字是否已经被使用

        // 对每一位进行逐步计算
        for (int i = 0; i < len; i++) {
            int digit = digits[i] - '0'; // 当前位的数字
            for (int j = (i == 0 ? 1 : 0); j < digit; j++) {
                if (!used[j]) {
                    count += calculateRemainingDigits(len - i - 1, used);
                }
            }
            if (used[digit]) {
                break; // 如果当前数字已经被使用，说明不存在符合条件的数字
            }
            used[digit] = true; // 标记当前数字被使用
        }

        // 如果所有位的数字都不重复，最后还要加上 n 自身
        if (!hasDuplicateDigits(digits)) {
            count++;
        }

        return count;
    }

    private int calculateRemainingDigits(int remaining, boolean[] used) {
        int count = 1;
        int available = 9 - countTrueValues(used); // 计算已经使用过的数字的数量
        for (int i = 0; i < remaining; i++) {
            count *= available--;
        }
        return count;
    }

    // 计算数组中 true 的数量
    private int countTrueValues(boolean[] array) {
        int count = 0;
        for (boolean value : array) {
            if (value) {
                count++;
            }
        }
        return count;
    }

    // 判断数字中是否有重复
    private boolean hasDuplicateDigits(char[] digits) {
        boolean[] seen = new boolean[10];
        for (char digit : digits) {
            if (seen[digit - '0']) {
                return true;
            }
            seen[digit - '0'] = true;
        }
        return false;
    }
}
