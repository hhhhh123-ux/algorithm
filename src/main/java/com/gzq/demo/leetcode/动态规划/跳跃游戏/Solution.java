package com.gzq.demo.leetcode.动态规划.跳跃游戏;

public class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if(dp[i]){
                for (int j = 1; j <= nums[i] && i + j < n; j++) {
                    dp[j + i] = true;
                }
            }

            if (dp[n - 1]) {
                return dp[n - 1];
            }

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0,2,3}));
        System.out.println(canJump1(new int[]{0,2,3}));
    }

    public static boolean canJump1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = true;

                }

            }
            if (dp[len - 1]) {
                return true;
            }

        }
        return dp[len - 1];

    }


    public boolean canJump2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = true;

                }
            }

        }
        return dp[len - 1];

    }



}
