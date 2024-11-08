package com.gzq.demo.leetcode.每日1题.每种字符至少取K个;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().takeCharacters("a", 1));
    }

    public int takeCharacters(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String abc="abc";
        for (int i = 0; i < abc.length(); i++) {
            hashMap.put(abc.charAt(i), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if ( (hashMap.containsKey('a') && hashMap.get('a') < k) || ( hashMap.containsKey('b') && hashMap.get('b') < k) || ( hashMap.containsKey('c') && hashMap.get('c') < k)) {
            return -1;
        }

        int left = 0, right = 0;
        int count = s.length();
        for (right = 0; right < s.length(); right++) {
            hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) - 1);
            while (left < right && (hashMap.get('a') < k || hashMap.get('b') < k || hashMap.get('c') < k)) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) + 1);
                left++;
            }
            if (hashMap.get('a') >= k && hashMap.get('b') >= k && hashMap.get('c') >= k) {
                count = Math.min(count, s.length() - (right - left + 1));
            }

        }

        return count;


    }

    private boolean isValid(HashMap<Character, Integer> hashMap, int k) {
        if (hashMap.containsKey('a') && hashMap.get('a') < k) return false;
        if (hashMap.containsKey('b') && hashMap.get('b') < k) return false;
        if (hashMap.containsKey('c') && hashMap.get('c') < k) return false;
        return true;
    }
}