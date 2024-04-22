package com.gzq.demo.leetcode.数组.寻找旋转排序数组中的最小值;

public class Solution1 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid >= 1 && mid <= nums.length - 2) {
                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    min = nums[mid];
                    break;
                }
            } else {
                min = nums[mid];
            }
            if (nums[mid] >= nums[0] && nums[mid] > nums[nums.length - 1]) {
                start = mid + 1;
            } else if (nums[mid] < nums[0] && nums[mid] <= nums[nums.length - 1]) {
                end = mid - 1;
            }

            if (nums[0] <= nums[mid] && nums[mid] <= nums[nums.length - 1]) {
                min = nums[0];
                break;
            }


        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findMin(new int[]{3, 1, 2}));
    }
}
