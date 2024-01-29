package com.gzq.demo.leetcode.滑动窗口.字符串的排列;

public class Solution1 {
    public static boolean checkInclusion(String s1, String s2) {
        boolean check = false;
        int start = 0;
        int end = 0;
        int s2Len = s2.length();
        int s1Len = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < s1Len; i++) {
            int x = s1.charAt(i) - 'a';
            count[x]--;

        }
        for (end = 0; end < s2Len; end++) {
            int x = s2.charAt(end) - 'a';
            count[x]++;
            while (count[x] > 0) {
                int y = s2.charAt(start) - 'a';
                count[y]--;
                start++;
            }
            if (end - start + 1 == s1Len) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ab";
        System.out.println(checkInclusion(s1, s2));

    }
}
