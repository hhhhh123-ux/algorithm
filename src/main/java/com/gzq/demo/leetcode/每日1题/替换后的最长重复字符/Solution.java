package com.gzq.demo.leetcode.每日1题.替换后的最长重复字符;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0;
        int[] ints = new int[26];
        int maxCount = 0;
        for (int right = 0; right < s.length(); right++) {
            ints[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, ints[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                ints[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
