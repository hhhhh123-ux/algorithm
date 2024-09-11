package com.gzq.demo.leetcode.Z字形变换;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().convert("ABC", 2));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int m = s.length();  // 列数不会超过字符串长度
        String[][] dp = new String[m][numRows];
        int row = 0, col = 0;
        boolean goingDown = true;
        for (char c : s.toCharArray()) {
            dp[col][row] = String.valueOf(c);
            if (goingDown) {
                row++;
            } else {
                row--;
                col++;
            }
            if (row == numRows) { // 到底部转折
                row = numRows - 2;
                goingDown = false;
                col++;
            } else if (row == -1) { // 到顶部转折
                row = 1;
                goingDown = true;
            }
        }
        // 将 dp 数组中的字符拼接成最终字符串
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {  // 先遍历行
            for (int i = 0; i < m; i++) {    // 再遍历列
                if (dp[i][j] != null) {
                    result.append(dp[i][j]);
                }
            }
        }

        return result.toString();
    }
}
