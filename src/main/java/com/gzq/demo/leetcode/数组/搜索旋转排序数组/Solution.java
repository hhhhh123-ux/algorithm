package com.gzq.demo.leetcode.数组.搜索旋转排序数组;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    /*
     *   暴力破解
     * 时间复杂度位O(n)
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
