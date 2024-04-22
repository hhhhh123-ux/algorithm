package com.gzq.demo.leetcode.寻找峰值;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid >= 1 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }else{
                if (mid == 0) {
                    return nums[mid] > nums[mid + 1] ? mid : mid + 1;
                } else {
                    return nums[mid] > nums[mid - 1] ? mid : mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{2, 1}));
    }
}
