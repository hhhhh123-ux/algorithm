package com.gzq.demo.leetcode.数组.单词搜索;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public List<String> findWords(char[][] board) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        int m = board.length;
        int n = board[0].length;
        Set<String> words = new HashSet<>(); // 存储所有符合条件的单词

        // 遍历整个二维网格
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n]; // 记录已访问过的单元格
                dfs(board, i, j, "", visited, words); // 从当前位置开始深度优先搜索
            }
        }

        result.addAll(words);
        return result;
    }

    private void dfs(char[][] board, int i, int j, String current, boolean[][] visited, Set<String> words) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return; // 超出边界或当前位置已访问过
        }

        current += board[i][j]; // 将当前字符添加到当前单词中
        visited[i][j] = true; // 标记当前位置已访问

//        if (current.length() > 1) {
            words.add(current); // 将当前单词添加到符合条件的单词集合中
//        }

        // 继续在当前位置的上下左右四个方向进行搜索
        dfs(board, i + 1, j, current, visited, words);
        dfs(board, i - 1, j, current, visited, words);
        dfs(board, i, j + 1, current, visited, words);
        dfs(board, i, j - 1, current, visited, words);

        // 回溯，将当前位置标记为未访问
        visited[i][j] = false;
    }

    public static void main(String[] args) {

    System.out.println( new Solution1().findWords(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}));
    }
}

