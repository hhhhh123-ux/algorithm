package com.gzq.demo.leetcode.数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
