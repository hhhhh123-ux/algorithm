package com.gzq.demo.leetcode.Z字形变换;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("ABC", 2));
    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        if (s.length() < numRows) {
            return s;
        }
        int m = (s.length() / numRows) * 3;
        String[][] dp = new String[m][numRows];
        Queue<String> queue = new LinkedList<>();
        // 将字符串中的每个字符逐个插入队列
        int mm = 0;
        for (int i = 0; i < s.length(); i++) {
            int nn = 0;
            int cc = numRows - 1;
            while (!queue.isEmpty() && queue.size() == numRows + (numRows - 2)) {
                while (!queue.isEmpty()) {
                    if (queue.size() <= numRows - 2) {
                        mm++;
                        cc = cc - 1;
                        dp[mm][cc] = queue.poll();
                        if (queue.size() == 0) {
                            mm++;
                        }
                    } else {
                        dp[mm][nn] = queue.poll();
                        nn++;
                    }
                }
            }
            queue.offer(s.charAt(i) + "");
        }

        // 打印 dp 数组
        // 打印 dp 数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < numRows; j++) {
                // 打印每个元素，使用三元运算符处理 null 值
                System.out.print((dp[i][j] != null ? dp[i][j] : " ") + " ");
            }
            // 每行打印结束后换行
            System.out.println();
        }
        // 将 dp 数组中的字符拼接成最终字符串

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {   // 先遍历列
            for (int i = 0; i < m; i++) {      // 再遍历行
                if (dp[i][j] != null) {
                    result.append(dp[i][j]);
                }
            }
        }
        return result.toString();
    }
}
