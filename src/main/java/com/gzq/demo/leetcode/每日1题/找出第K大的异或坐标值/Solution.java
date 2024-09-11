package com.gzq.demo.leetcode.每日1题.找出第K大的异或坐标值;

import java.util.Arrays;

public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = matrix[0][0];
                } else if (i == 0) {
                    int c = matrix[i][0];
                    for (int x = 1; x <= j; x++) {
                        int f = matrix[i][x];
                        c = c ^ f;
                    }
                    result[i][j] = c;
                } else if (j == 0) {
                    int c = matrix[0][j];
                    for (int x = 1; x <= i; x++) {
                        int f = matrix[x][j];
                        c = c ^ f;
                    }
                    result[i][j] = c;
                } else {
                    int c = 0;
                    for (int a = 0; a <= i; a++) {
                        for (int b = 0; b <= j; b++) {
                            int f = matrix[a][b];
                            c = f ^ c;
                        }
                    }
                    result[i][j] = c;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        int[] res = new int[m * n];
        int h = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[h++] = result[i][j];
            }
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        return res[m * n - k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}, {2, 3}}, 1));
    }
}
