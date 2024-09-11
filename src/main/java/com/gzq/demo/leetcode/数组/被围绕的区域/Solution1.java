package com.gzq.demo.leetcode.数组.被围绕的区域;

public class Solution1 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // 打印完一行后换行
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        System.out.println(); // 打印完一行后换行
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // 打印完一行后换行
        }
    }


    public void dfs(char[][] board, int start, int end) {
        if (start < 0 || end < 0 || start >= board.length || end >= board[0].length) {
            return;
        }
        if (board[start][end] == 'X' || board[start][end] == 'A') {
            return;
        }
        for (int i = start; i < start+1; i++) {
            for (int j = end; j < end+1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'A';
                }
                //往当前i，j节点上i-1查询
                dfs(board, i - 1, j);
                dfs(board, i + 1, j);
                dfs(board, i, j - 1);
                dfs(board, i, j + 1);
            }
        }

    }

    public static void main(String[] args) {
        new Solution1().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
