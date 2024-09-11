package com.gzq.demo.leetcode.每日1题.找出满足差值条件的下标I;

import java.util.Arrays;

public class Solution1 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            // Ensure the pointers have the minimum index difference
            if (right - left >= indexDifference) {
                if (Math.abs(nums[left] - nums[right]) >= valueDifference) {
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
                left++;
            } else {
                right++;
            }
            // Move the right pointer to ensure index difference
            if (right - left < indexDifference) {
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().findIndices(new int[]{5, 1, 4, 1}, 2, 4)));
    }
}
