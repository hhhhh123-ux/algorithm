package com.gzq.demo.leetcode.每日1题.清除数字;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().clearDigits("abc"));
    }

    public static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) {
            return false; // 空字符串和null不是数字
        }
        try {
            Integer.parseInt(s); // 尝试将字符串转换为整数
            return true;
        } catch (NumberFormatException e) {
            return false; // 如果转换失败，说明不是整数
        }
    }

    public String clearDigits(String s) {
        String[] strings = s.split("");
        System.out.println(strings);
        Deque<String> deque = new ArrayDeque<>();
        for (String s1 : strings) {
            if (isNumeric(s1)) {
               deque.pollLast();
            }else{
                deque.add(s1);
            }

        }
        StringBuilder stringBuilder=new StringBuilder();
        for(String s1:deque){
            stringBuilder.append(s1);
        }
        s=stringBuilder.toString();
        System.out.println("s=="+s);
        return s;
    }
}
