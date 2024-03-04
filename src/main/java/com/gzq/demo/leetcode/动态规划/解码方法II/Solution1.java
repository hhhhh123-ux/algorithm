package com.gzq.demo.leetcode.动态规划.解码方法II;

public class Solution1 {
    public int numDecodings(String s) {
        int len = s.length();
        int mod = (int) 1e9 + 7;
        long[] dp = new long[len];
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[0] = 9;
        }
        for (int i = 1; i < len; i++) {
            //判断当前字符为数字
            if (s.charAt(i) != '*') {
                //判断当前字符不为0
                if (s.charAt(i) != '0') {
                    // 当前s.charAt(i)字段为1,2,3,4,5,6,7,8,9
                    if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                        dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
                    } else if (s.charAt(i - 1) == '*') {
                        if (s.charAt(i) < '7') {
                            dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1) * 2;
                        } else {
                            dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
                        }
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    // 当前字段为0
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        dp[i] = (i - 2 >= 0) ? dp[i - 2] : dp[i - 1];
                    } else if (s.charAt(i - 1) != '*') {
                        dp[i] = 0;
                    } else {
                        dp[i] = 2 * (i - 2 >= 0 ? dp[i - 2] : 1);
                    }
                }

            }
            //判断当前字符为*
            else {
                //当前i字段为*
                //当前i-1 为1,2
                if (s.charAt(i - 1) == '1') {
                    dp[i] = dp[i - 1] * 9 + (i - 2 >= 0 ? dp[i - 2] : 1) * 9;
                } else if (s.charAt(i - 1) == '2') {
                    dp[i] = 9 * dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1) * 6;
                } else if (s.charAt(i - 1) == '*') {
                    dp[i] = dp[i - 1] * 9 + (i - 2 >= 0 ? dp[i - 2] : 1) * 15;
                } else {
                    dp[i] = dp[i - 1] * 9;
                }
            }
            dp[i] = dp[i] % mod;
        }
        return (int) dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numDecodings("1*6*7*1*9*6*2*9*2*3*3*6*3*2*2*4*7*2*9*6*0*6*4*4*1*6*9*0*5*9*2*5*7*7*0*6*9*7*1*5*5*9*3*0*4*9*2*6*2*5*7*6*1*9*4*5*8*4*7*4*2*7*1*2*1*9*1*3*0*6*"));
    }
}
