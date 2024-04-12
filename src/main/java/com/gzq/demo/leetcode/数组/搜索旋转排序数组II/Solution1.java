package com.gzq.demo.leetcode.数组.搜索旋转排序数组II;


public class Solution1 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[mid] < target && target <= nums[right]) {
                    if (nums[mid] == nums[right]) {
                        right--;
                        continue;
                    }
                    left = mid + 1;
                } else {
                    if (nums[mid] == nums[left]) {
                        left++;
                        continue;
                    }
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    if (nums[mid] == nums[left]) {
                        left++;
                        continue;
                    }
                    right = mid - 1;
                } else {
                    if (nums[mid] == nums[right]) {
                        right--;
                        continue;
                    }
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().search(new int[]{3, 5, 1}, 1));
    }
}
