package com.gzq.demo.leetcode.数组.字母异位词分组;

import java.util.*;

public class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            char[] chars =s.toCharArray();
            Arrays.sort(chars);
            System.out.println(chars);
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < s.length(); j++) {
                treeMap.put(s.charAt(j) - '0', treeMap.getOrDefault(s.charAt(j) - '0', 0) + 1);
            }
            String key = "";
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                key = key + entry.getKey().toString() + entry.getValue().toString();
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
