package com.gzq.demo.leetcode.数组.计数质数;

public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            double sqrt_n = Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 2; j <= sqrt_n; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
    }
}
