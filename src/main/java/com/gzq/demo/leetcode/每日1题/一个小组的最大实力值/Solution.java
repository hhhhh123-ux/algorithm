package com.gzq.demo.leetcode.每日1题.一个小组的最大实力值;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxStrength(new int[]{6, -3, -4, 8, 4, 7, 6, 4, 7, 7, -3, -6, 9}));
    }

    public long maxStrength(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        long[] dp = new long[nums.length];
        Arrays.sort(nums);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] * nums[i];
                } else if (dp[i - 1] < 0) {
                    if (i >= 2) {
                        if (dp[i - 2] > 0) {
                            dp[i] = nums[i] * dp[i - 2];
                        } else {
                            dp[i] = nums[i];
                        }
                    } else if (i < 2) {
                        dp[i] = nums[i];
                    }

                } else if (dp[i - 1] == 0) {
                    dp[i] = nums[i];
                }
            } else if (nums[i] < 0) {
                dp[i] = dp[i - 1] * nums[i];
            } else if (nums[i] == 0) {
                if (i >= 2) {
                    long res = (dp[i - 1] > dp[i - 2]) ? dp[i - 1] : dp[i - 2];
                    dp[i] = res;
                }
                if (i < 2) {
                    dp[i] = nums[i];
                }

            }

        }
        long res = (dp[nums.length - 1] > dp[nums.length - 2]) ? dp[nums.length - 1] : dp[nums.length - 2];
        return res;
    }
}
