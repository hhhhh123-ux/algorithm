package com.gzq.demo.leetcode.每日1题.找出第K大的异或坐标值;

import java.util.Arrays;

public class Solution1 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int h = 0;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = matrix[0][0];
                } else if (i == 0) {
                    int c = matrix[i][j] ^ result[i][j - 1];
                    result[i][j] = c;
                } else if (j == 0) {
                    int c = matrix[i][j] ^ result[i - 1][j];
                    result[i][j] = c;
                } else {
                    int c = result[i][j - 1];
                    for (int a = 0; a <= i; a++) {
                        int f = matrix[a][j];
                        c = f ^ c;
                    }
                    result[i][j] = c;
                }
                res[h++] = result[i][j];
            }
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        return res[m * n - k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().kthLargestValue(new int[][]{{5, 2}, {1, 6}, {2, 3}}, 1));
        System.out.println(5^4^7^6);
    }
}
