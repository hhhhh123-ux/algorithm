package com.gzq.demo.leetcode.数组.岛屿数量;


public class Solution {
    private int count = 0;


    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j, dp);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || dp[i][j] == 1) {
            return;
        }
        dp[i][j] = 1;
        grid[i][j] = 0;
        dfs(grid, i + 1, j, dp);
        dfs(grid, i - 1, j, dp);
        dfs(grid, i, j + 1, dp);
        dfs(grid, i, j - 1, dp);
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        //System.out.println(new Solution().numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
        System.out.println(new Solution().numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'0', '1', '0'}}));
    }
}
