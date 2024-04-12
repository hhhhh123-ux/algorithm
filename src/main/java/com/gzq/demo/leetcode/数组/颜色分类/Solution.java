package com.gzq.demo.leetcode.数组.颜色分类;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            if (nums[begin] < nums[end]) {
                int temp1 = nums[begin];
                int temp2 = nums[begin + 1];
                if (temp2 < temp1) {
                    end--;
                } else if (temp2 > temp1) {
                    begin++;
                } else if (temp2 == temp1) {
                    begin++;
                }
            } else if (nums[begin] == nums[end]) {
                int temp = nums[end];
                int temp1 = nums[begin];
                int temp2 = nums[end - 1];
                int temp3 = nums[begin + 1];
                if (temp2 < temp) {
                    nums[begin] = temp2;
                    nums[end] = temp;
                    nums[end - 1] = temp1;
                    begin++;
                } else if (temp2 == temp) {
                    begin++;
                }
            } else {
                int temp = nums[begin];
                int temp1 = nums[end];
                nums[end] = temp;
                nums[begin] = temp1;
                end--;
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{1, 0, 9, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0});
    }
}
