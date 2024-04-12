package com.gzq.demo.leetcode.数组.搜索旋转排序数组;

public class Solution1 {

    /*
     *   暴力破解
     * 时间复杂度位O(log(n))
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        int r = length - 1;
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int i = 0;
        while (i <= r) {
            int mid = (i + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                //左边
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                //右边
                if (nums[mid] < target && target <= nums[length - 1]) {
                    i = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().search(new int[]{1, 0, 1, 1, 1}, 0));
    }
}
