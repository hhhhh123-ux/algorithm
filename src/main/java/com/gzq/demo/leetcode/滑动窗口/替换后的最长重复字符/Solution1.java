package com.gzq.demo.leetcode.滑动窗口.替换后的最长重复字符;


public class Solution1 {
    public static int characterReplacement(String s, int k) {
        int count = 0;
        int len = s.length();
        int end = 0;
        int maxCount = 0;
        int start = 0;
        int[] charCount = new int[26];
        for (end = 0; end < len; end++) {
            charCount[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            } else {
                count = Math.max(count, end - start + 1);
            }
        }
        return count;
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
