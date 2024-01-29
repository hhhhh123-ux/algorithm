package com.gzq.demo.leetcode.滑动窗口.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        long startTime = System.currentTimeMillis(); // 记录开始时间
        List<Integer> integers = new ArrayList<>();
        int start = 0;
        int end = 0;
        int len = s.length();
        int pLen = p.length();
        for (end = pLen - 1; end < len; end++) {
            int[] count = new int[26];
            for (int i = 0; i < pLen; i++) {
                count[p.charAt(i) - 'a']++;
            }
            boolean hasNegative = false;
            for (int pp = 0; pp < pLen; pp++) {
                count[s.charAt(end - pp) - 'a']--;
            }

            for (int i = 0; i < count.length; i++) {
                if (count[i] < 0) {
                    hasNegative = true;
                    break;  // 找到一个小于 0 的元素后就跳出循环
                }
            }
            if (hasNegative) {
                System.out.println("数组中存在元素小于 0");
            } else {
                System.out.println("数组中所有元素都大于等于 0");
                integers.add(end - pLen + 1);

            }

        }
        long endTime = System.currentTimeMillis(); // 记录结束时间
        long duration = endTime - startTime; // 计算耗时（单位为毫秒）

        System.out.println("方法耗时：" + duration + "ms");

        return integers;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}

