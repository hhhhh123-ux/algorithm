package com.gzq.demo.leetcode.每日1题.找出出现至少三次的最长特殊子字符串I;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    public int maximumLength(String s) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (check(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }

            }
        }
        TreeMap<String, Integer> sortedMap = map.entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        () -> new TreeMap<>(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                int lengthCompare = Integer.compare(o1.length(), o2.length());
                                if (lengthCompare == 0) {
                                    return o1.compareTo(o2); // 如果长度相同，按字典顺序排序
                                }
                                return lengthCompare;
                            }
                        })
                ));
        if (sortedMap.size() != 0) {
            return sortedMap.lastEntry().getKey().length();
        }
        return -1;
    }

    public boolean check(String s) {
        char first = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
}
