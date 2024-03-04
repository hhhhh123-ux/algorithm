package com.gzq.demo.leetcode.动态规划.解码方法II;

public class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        if(n == 0 || s.charAt(0) == '0')  return 0;
        long[] dp = new long[n + 1];
        char[] a = (" " + s).toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(a[i] == '*'){
                dp[i] = (9 * dp[i - 1]) % mod;
                if(a[i - 1] == '1') dp[i] = (dp[i] + 9 * dp[i - 2]) % mod;
                else if(a[i - 1] == '2') dp[i] =(dp[i] +  6 * dp[i - 2]) % mod;
                else if(a[i - 1] == '*') dp[i] =(dp[i] + 15 * dp[i - 2]) % mod;
            }else if(a[i] == '0'){
                if(a[i - 1] == '1') dp[i] = dp[i - 2];
                else if(a[i - 1] == '2') dp[i] = dp[i - 2];
                else if(a[i - 1] == '*') dp[i] = 2 * dp[i - 2] % mod;
                else return 0;
            }else{
                dp[i] = dp[i - 1];
                if(a[i - 1] == '1') dp[i] = (dp[i] + dp[i - 2]) % mod;
                else if(a[i - 1] == '2' && a[i] - '0' >= 1 && a[i] - '0' <= 6) dp[i] = (dp[i] + dp[i - 2]) % mod;
                else if(a[i - 1] == '*'){
                    if( a[i] - '0' >= 7 && a[i] - '0' <= 9) dp[i] = (dp[i] + dp[i - 2]) % mod;
                    else dp[i] = (dp[i] + 2 * dp[i - 2]) % mod;
                }
            }

        }
        return (int) (dp[n] % mod);
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().numDecodings("*********"));
    }
}
