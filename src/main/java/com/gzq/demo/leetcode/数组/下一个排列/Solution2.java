package com.gzq.demo.leetcode.数组.下一个排列;

import java.util.Arrays;

public class Solution2 {
    public void nextPermutation(int[] nums) {
        Boolean flag = true;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int right = nums[i];
            if (right > nums[i - 1]) {
                temp1 = nums[i - 1];
                for (int j = nums.length - 1; j > 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        temp2 = nums[j];
                        nums[j] = temp1;
                        break;
                    }
                }
                nums[i - 1] = temp2;
                Arrays.sort(nums, i, nums.length);
                flag = false;
                break;
            }
        }
        if (flag) {
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution2().nextPermutation(new int[]{2, 3, 1});
    }
}
