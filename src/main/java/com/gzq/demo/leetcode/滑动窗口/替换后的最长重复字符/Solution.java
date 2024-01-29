package com.gzq.demo.leetcode.滑动窗口.替换后的最长重复字符;

import java.util.Arrays;

public class Solution {
    /**
     * 给定一个字符串 s 和一个整数 k。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行k次。
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int count = 0;
        if (len <= k) {
            return len;
        }
        int start = 0;
        int end = 0;
        for (start = 0; start < len; start++) {
            for (end = len; end > start; end--) {
                count = Math.max(count, countChar(s, start, end, k));
            }
        }
        return count;
    }

    public static int countChar(String s, int start, int end, int k) {
        int[] charCount = new int[26];
        for (int i = start; i < end; i++) {
            charCount[s.charAt(i) - 'A']++;
        }
        int maxCount = Arrays.stream(charCount).max().getAsInt();
        if (end - start - maxCount <= k) {
            System.out.println( "end-"+"start"+"=count " +end+"-"+start+"="+(end-start));
            return end - start;
        }
        return 0;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // 记录开始时间
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;
        System.out.println(characterReplacement(s, k));
        long end = System.currentTimeMillis(); // 记录结束时间
        long duration = end - start; // 计算运行时间差值（单位为毫秒）
        System.out.println("程序运行时间3：" + duration + "ms");
        long second = duration / 1000; // 计算运行时间差值（单位为秒）
        System.out.println("程序运行时间3:" + second + "s");
        if (second > 0) {
            long minute = second / 60; // 计算运行时间差值（单位为分钟）
            System.out.println("程序运行时间3:" + minute + "m");
        }
    }
}
