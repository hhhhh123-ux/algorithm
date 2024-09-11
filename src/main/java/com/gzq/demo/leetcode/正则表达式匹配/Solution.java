package com.gzq.demo.leetcode.正则表达式匹配;

public class Solution {
    public static void main(String[] args) {
        String ss = "ab";
        String p = ".*";
        System.out.println(new Solution().isMatch(ss, p));
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[2][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = s.charAt(i);
        }
        int m = 0;
        for (int i = 0; i < p.length(); i++) {
            Character character = p.charAt(i);
            System.out.println(character);
            if (String.valueOf(character).equals(".")) {
                dp[1][m] = dp[0][m];
                m++;
            }
            if (String.valueOf(character).equals("*")) {
                character = p.charAt(i - 1);
                if (String.valueOf(character).equals(".")) {
                    dp[1][m] = dp[0][m];
                    if (m < s.length() - 1) {
                        m++;
                    }

                }

            }
            if (dp[0][m] == character) {
                dp[1][m] = character;
                m++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i] != dp[1][i]) {
                return false;
            }
        }
        return true;
    }
}
