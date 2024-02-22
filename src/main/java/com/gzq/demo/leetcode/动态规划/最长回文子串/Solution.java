package com.gzq.demo.leetcode.动态规划.最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        // 2. 子问题计算顺序：先计算短字符串，在计算长字符串，同时根据已求得的短字符串或者计算规则，可以得到长字符串的解。
        // 注意：s表示计算的元素顺序。
        //     0   1   2  3  4
        // 0   xx s1  s2 s4 s7
        // 1      xx  s3 s5 s8
        // 2          xx s6 s9
        // 3             xx s10
        // 4                xx
        // 为什么这么写呢，因为你要保证保证计算某个元素时，通过状态转移方程能得到左上角元素的dp[][]。
        // 填表规则：先一列一列的填写，再一行一行的填，保证计算某个元素时，它左上方的单元格已经被计算出了结果
        // 填表规则：当然你也可以由左往右一行一行写，这样也能保证计算某个元素时，它左上方的单元格已经被计算出了结果
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 因为考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i - 1 <= 1) {
                        dp[i][j] = true;
                    } else {
                        // 头尾相等，中间有大于1个元素，这个时候，我们无法直接判断他是不是回文，但是我们可以通过状态转移方程去判断

                        // 其实这个就是在计算s8这个元素时，我们无法判断dp[1][4]在1和4位元素相等时候，整个字符串是否是回文。
                        // 所以要通过s4去判断，s4是回文，s8就是。s4不是，那s8就不是。
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}