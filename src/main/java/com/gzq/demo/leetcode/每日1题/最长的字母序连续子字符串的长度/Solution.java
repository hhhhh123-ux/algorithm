package com.gzq.demo.leetcode.每日1题.最长的字母序连续子字符串的长度;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestContinuousSubstring("abcde"));
    }

    public int longestContinuousSubstring(String s) {
        int longest = 0;
        String str = "abcdefghijklmnopqrstuvwxyz";
        int left = 0;
        for (int right = left + 1; right <= s.length(); right++) {
            String ss = s.substring(left, right);
            System.out.println(ss);
            System.out.println(ss.length());
            if (str.contains(ss)) {
                System.out.println(true);
                longest = Math.max(longest, ss.length());
            }else
            {
                left = right-1;
            }
        }
        return longest;
    }
}
