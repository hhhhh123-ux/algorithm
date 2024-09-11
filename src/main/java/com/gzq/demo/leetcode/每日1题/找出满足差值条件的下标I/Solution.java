package com.gzq.demo.leetcode.每日1题.找出满足差值条件的下标I;

import java.util.Arrays;

public class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;


            }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findIndices(new int[]{5, 1, 4, 1}, 2, 4)));
    }
}
