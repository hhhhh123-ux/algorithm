package com.gzq.demo.leetcode.寻找峰值;

public class Solution1 {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // 检查 mid 是否是峰值
            if (nums[mid] > nums[mid + 1]) {
                // 如果 nums[mid] > nums[mid+1]，则峰值可能在左侧或当前位置
                // 缩小搜索范围至左侧
                end = mid;
            } else {
                // 否则，峰值可能在右侧
                // 缩小搜索范围至右侧
                start = mid + 1;
            }
        }

        // 循环结束时，start == end，即找到了峰值
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findPeakElement(new int[]{1,2}));
    }
}
