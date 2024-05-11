package com.gzq.demo.leetcode.数组.生命游戏;

public class Solution1 {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + ":" + j);
                int count = dfs(board, i, j, 0, 0);
                dp[i][j] = count;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (dp[i][j] == 3 || dp[i][j] == 2) {
                        board[i][j] = 1;
                    } else if (board[i][j] < 2) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 0;
                    }
                } else if (board[i][j] == 0) {
                    if (dp[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }


    public int dfs(int[][] board, int i, int j, int storey, int count) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || storey >= 2) {
            return count;
        }
        if (board[i][j] == 1 && storey == 1) {
            count++;
        }
        if (storey == 0) {
            int result = dfs(board, i - 1, j, storey + 1, count);
            int re = dfs(board, i - 1, j + 1, storey + 1, count);
            int re1 = dfs(board, i - 1, j - 1, storey + 1, count);
            int result1 = dfs(board, i + 1, j, storey + 1, count);
            int result2 = dfs(board, i + 1, j - 1, storey + 1, count);
            int result3 = dfs(board, i + 1, j + 1, storey + 1, count);
            int result4 = dfs(board, i, j - 1, storey + 1, count);
            int result5 = dfs(board, i, j + 1, storey + 1, count);
            count = result + re + result1 + result2 + result3 + result4 + result5 + re1;
        }
        return count;
    }


    public static void main(String[] args) {
        new Solution1().gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
