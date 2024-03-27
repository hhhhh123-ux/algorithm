package com.gzq.demo.leetcode.数组.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (j == 0) {
                    result[j++] = i;
                }
                if(j==1){
                    result[j] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
