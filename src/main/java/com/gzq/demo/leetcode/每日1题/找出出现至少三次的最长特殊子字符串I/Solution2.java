package com.gzq.demo.leetcode.每日1题.找出出现至少三次的最长特殊子字符串I;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution2 {
    public int maximumLength(String s) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && check(s, i, j+1)) {
                String sub = s.substring(i, j + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if (map.get(sub) >= 3) {
                    maxLength = Math.max(sub.length(), maxLength);
                }
                j++;
            }
        }

        return maxLength;
    }

    public boolean check(String s, int start, int end) {
        char first = s.charAt(start);
        for (int i = start; i < end; i++) {
            if (s.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
}
