package com.gzq.demo.leetcode.数组.寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                // mid 到 end 之间的元素是递增的，最小值位于 [start, mid] 区间内
                end = mid;
            } else if (nums[mid] > nums[end]) {
                // mid 到 end 之间的元素中存在旋转点，最小值位于 [mid+1, end] 区间内
                start = mid + 1;
            } else {
                // nums[mid] == nums[end]，无法判断最小值在哪一侧，因此缩小搜索范围
                end--;
            }
        }

        // 循环结束时 start == end，即找到了最小值
        return nums[start];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
