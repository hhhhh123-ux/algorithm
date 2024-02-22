package com.gzq.demo.leetcode.动态规划.不同路径II;

public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else if (obstacleGrid[i][j] == 0) {
                        if (i == 0 && j == 0) {
                            dp[i][j] = 1;
                        } else {
                            if (i == 0) {
                                dp[i][j] = dp[i][j - 1];
                            } else if (j == 0) {
                                dp[i][j] = dp[i - 1][j];
                            } else {
                                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                            }
                        }
                    }
                } else {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {1, 0}
        }));
    }
}
