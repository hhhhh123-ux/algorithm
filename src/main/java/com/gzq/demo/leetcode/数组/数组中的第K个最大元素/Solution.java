package com.gzq.demo.leetcode.数组.数组中的第K个最大元素;


import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        reverseArray(nums);
        return nums[k - 1];
    }

    public void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 交换左右指针指向的元素
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            // 移动左右指针
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2));
    }
}
