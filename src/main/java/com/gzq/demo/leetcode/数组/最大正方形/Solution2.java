package com.gzq.demo.leetcode.数组.最大正方形;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSquare = 0; // 最大正方形的边长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxSquare = Math.max(maxSquare, dfs(matrix, i, j));
                }
            }
        }
        // 计算最大正方形的边长
        return maxSquare * maxSquare;
    }

    private int dfs(char[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 判断越界情况
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == '0') {
            return 0;
        }
        return 1 + Math.min(dfs(matrix, i + 1, j), Math.min(dfs(matrix, i, j + 1), dfs(matrix, i + 1, j + 1)));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
