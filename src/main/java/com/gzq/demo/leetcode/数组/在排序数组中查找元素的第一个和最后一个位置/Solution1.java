package com.gzq.demo.leetcode.数组.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

public class Solution1 {

    /*
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            if (nums[0] != target) {
                return result;
            } else {
                return result = new int[]{0, 0};
            }
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return result;
        }
        int i = 0;
        int length = nums.length;
        int r = length - 1;
        while (i <= r) {
            int mid = (i + r) / 2;
            if (nums[mid] < target && target <= nums[length - 1]) {
                i = mid + 1;
            } else if (nums[0] <= target && target < nums[mid]) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                int left = mid;
                int right = mid;
                while (nums[left] == nums[right]) {
                    if (left > 0 && nums[left - 1] == target) {
                        left--;
                    }
                    if (right < length - 1 && nums[right + 1] == target) {
                        right++;
                    }
                    if (!(left > 0 && nums[left - 1] == target) && !(right < length - 1 && nums[right + 1] == target)) {
                        return result = new int[]{left, right};
                    }
                }
            } else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().searchRange(new int[]{2, 2}, 2)));
    }

}
