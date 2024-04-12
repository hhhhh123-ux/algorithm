package com.gzq.demo.leetcode.数组.搜索二维矩阵;

public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        Boolean result = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
                for (int j = 0; j < n; j++) {
                     if(matrix[i][j] == target){
                         result=true;
                         break;
                     }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().searchMatrix(new int[][]{
                {1}
        }, 1));
    }
}
