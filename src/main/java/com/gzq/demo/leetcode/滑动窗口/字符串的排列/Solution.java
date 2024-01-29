package com.gzq.demo.leetcode.滑动窗口.字符串的排列;

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        boolean check = false;
        int start = 0;
        int end = 0;
        int s2Len = s2.length();
        int s1Len = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < s1Len; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (end = s1Len - 1; end < s2Len; end++) {

        }

        return check;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidabooo";
        System.out.println(checkInclusion(s1, s2));

    }
}
