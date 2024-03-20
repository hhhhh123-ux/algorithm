package com.gzq.demo.leetcode.数组.寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double median = (double) 0;
        int[] nums = mergeArrays(nums1, nums2);
        if (nums.length % 2 == 0) {
            if (nums.length != 0) {
                int num1 = nums[nums.length / 2-1];
                int num2 = nums[nums.length / 2+1-1];

                double num=(double) (num1+num2)/2;
                return num;
            }
        } else if (nums.length % 2 == 1) {
            int mid = (nums.length + 1) / 2;
            int num = nums[mid-1];
            return num;
        }
        return median;
    }


    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3,5}, new int[]{2,4}));
    }
}
