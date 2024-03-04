package com.gzq.demo.leetcode.动态规划.解码方法;

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = (i - 2 >= 0) ? dp[i - 2] : dp[i - 1];
                }
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
                    //dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("1123"));
    }
}
