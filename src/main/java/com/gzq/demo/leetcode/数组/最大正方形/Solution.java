package com.gzq.demo.leetcode.数组.最大正方形;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean[][] visited = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    List<List<Integer>> pairs = new ArrayList<>();
                    dfs(matrix, i, j, visited, pairs);
                }
            }
        }
        return count;
    }

    public Boolean dfs(char[][] matrix, int i, int j, Boolean[][] visited, List<List<Integer>> pairs) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return false;
        }
        visited[i][j] = true;
        pairs.add(Arrays.asList(i, j));
        if (dfs(matrix, i + 1, j, visited, pairs) && dfs(matrix, i, j + 1, visited, pairs) && dfs(matrix, i + 1, j + 1, visited, pairs)) {
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
