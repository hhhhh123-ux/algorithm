package com.gzq.demo.leetcode.每日1题.字符串中最多数目的子序列;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSubsequenceCount("mmpp", "mp"));
    }

    public static String removeCharacters(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (str2.contains(String.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        long c1 = 0, c2 = 0;
        long res = 0;
        char a1 = pattern.charAt(0), a2 = pattern.charAt(1);
        for (char c : text.toCharArray()) {
            if (a1 == c) {
                c1++;
            } else if (a2 == c) {
                c2++;
                res += c1;
            }
        }
        if(a1 == a2){
            return c1 * (c1 + 1) / 2;
        }
        return res+Math.max(c1,c2);
    }
}
