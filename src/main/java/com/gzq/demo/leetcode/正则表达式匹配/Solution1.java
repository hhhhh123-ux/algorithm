package com.gzq.demo.leetcode.正则表达式匹配;

public class Solution1 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[2][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = s.charAt(i);
        }

        int sIndex = 0;
        for (int i = 0; i < m && sIndex < n; i++) {
            char patternChar = p.charAt(i);

            if (patternChar == '.') {
                dp[1][sIndex] = dp[0][sIndex];
                sIndex++;
            } else if (patternChar == '*') {
                char prevChar = p.charAt(i - 1);
                if (prevChar == '.') {
                    while (sIndex < n) {
                        dp[1][sIndex] = dp[0][sIndex];
                        sIndex++;
                    }
                } else {
                    while (sIndex < n && dp[0][sIndex] == prevChar) {
                        dp[1][sIndex] = prevChar;
                        sIndex++;
                    }
                }
            } else {
                if (sIndex < n && dp[0][sIndex] == patternChar) {
                    dp[1][sIndex] = patternChar;
                    sIndex++;
                }
            }
        }

        // 检查是否完全匹配
        return sIndex == n && dp[0][n-1] == dp[1][n-1];
    }

}
