package com.gzq.demo.leetcode.每日1题.找出出现至少三次的最长特殊子字符串I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (check(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }

            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) >= 3) {
                list.add(key.length());
            }
        }
        list.sort((o1, o2) -> o2 - o1);
        if (list.size() != 0) {
            return list.get(0);
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
        System.out.println(new Solution().maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
}
