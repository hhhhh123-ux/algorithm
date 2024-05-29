package com.gzq.demo.leetcode.动态规划.超级丑数;

import java.util.*;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 动态规划
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        int m = primes.length;
        // 计数数组，将每个质数所累乘的个数记录
        int[] pointers = new int[m];
        // 每个都初始化为0
        Arrays.fill(pointers, 0);
        // 直到找到对应的数
        for (int i = 1; i < n; i++) {
            int minNum = Integer.MAX_VALUE;
            int minBase = 0;
            for (int j = 0; j < m; j++) {
                // 为什么用的是pointers[]，而不是直接i-1
                // 因为这是一个多指针的问题，不能直接在dp[i-1]的基础上往上乘一个质数
                // 对于dp数组中的每一个数，他们都要资格乘一个当前的质数
                int newNums = dp[pointers[j]] * primes[j];
                // 出现重复的要跳过，比如2*7与7*2
                if (newNums == minNum) {
                    pointers[j]++;
                    continue;
                }
                // 找到其中最小的
                if (newNums < minNum) {
                    minNum = newNums;
                    minBase = j;
                }
            }

            // 最小的当然就是下一个了
            dp[i] = minNum;
            // System.out.println(dp[i]);
            // 将对应的pointers指针后移
            pointers[minBase]++;
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};
        int n = 100000;
        int nthSuperUgly = solution.nthSuperUglyNumber(n, primes);
        System.out.println("第 " + n + " 个超级丑数是: " + nthSuperUgly);
    }
}

