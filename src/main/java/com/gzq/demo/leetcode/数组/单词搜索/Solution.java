package com.gzq.demo.leetcode.数组.单词搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Character>> result = new ArrayList<>();

    LinkedList<Character> temp = new LinkedList<>();

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n]; // 记录已访问过的单元格
                    backtracking(board, 0, i, j, word, visited);
                }
            }
        }
        System.out.println(result);
        return result.size() > 0;
    }

    void backtracking(char[][] board, int begin, int i, int j, String word, boolean[][] visited) {
        if (begin == word.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(begin)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j]=true;
        temp.add(board[i][j]);
        backtracking(board, begin + 1, i + 1, j, word, visited);
        backtracking(board, begin + 1, i - 1, j, word, visited);
        backtracking(board, begin + 1, i, j + 1, word, visited);
        backtracking(board, begin + 1, i, j - 1, word, visited);
        temp.removeLast();
        visited[i][j]=false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
