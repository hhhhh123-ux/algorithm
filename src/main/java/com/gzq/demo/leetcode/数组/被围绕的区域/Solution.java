package com.gzq.demo.leetcode.数组.被围绕的区域;

import java.util.*;

public class Solution {

    /*
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     *
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     *
     * X X X X
     *

     */

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // 打印完一行后换行
        }

        int m = board.length;
        int n = board[0].length;
        Boolean[][] visited = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        backtracking(board, 0, 0, m, n, false, visited, false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == true) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(); // 打印完一行后换行
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // 打印完一行后换行
        }

    }

    public void backtracking(char[][] board, int start, int end, int m, int n, Boolean flag, Boolean[][] visited, Boolean visited2) {
        if (start < 0 || end < 0 || start >= m || end >= n) {
            return;
        }
        if (flag == true && board[start][end] == 'X') {
            return;
        }
        if (visited[start][end] == true) {
            return;
        }
        System.out.println("start:" + start + " end:" + end);
        for (int i = start; i <m; i++) {
            for (int j = end; j < n; j++) {
                if (visited2 == true && board[i][j] == 'O') {
                    visited[i][j] = true;

                }
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        visited[i][j] = true;
                        //往当前i，j节点上i-1查询
                        backtracking(board, i - 1, j, m, n, true, visited, true);
                        backtracking(board, i + 1, j, m, n, true, visited, true);
                        backtracking(board, i, j - 1, m, n, true, visited, true);
                        backtracking(board, i, j + 1, m, n, true, visited, true);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve(new char[][]{{'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'X', 'X', 'X', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O'}});
    }
}
