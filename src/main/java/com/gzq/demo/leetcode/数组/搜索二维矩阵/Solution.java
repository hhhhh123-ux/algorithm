package com.gzq.demo.leetcode.数组.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        Boolean result = false;
        int m = matrix.length;
        int n = matrix[0].length;
        int begin = 0;
        int end = m * n - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));
    }
}
