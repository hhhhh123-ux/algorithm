package com.gzq.demo.leetcode.二叉树.不同的二叉搜索树;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(1));
    }
}
