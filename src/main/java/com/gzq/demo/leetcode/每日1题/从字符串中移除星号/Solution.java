package com.gzq.demo.leetcode.每日1题.从字符串中移除星号;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (character.toString().equals("*")) {
                deque.pollLast();
            } else {
                deque.add(character.toString());
            }

        }
        // 使用 StringBuilder 来拼接 deque 中的字符
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        s = stringBuilder.toString();
        return s;
    }
}
