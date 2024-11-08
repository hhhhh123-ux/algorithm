package com.gzq.demo.leetcode.每日1题.最佳观光组合;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(max,values[i] + values[j] + i - j);
            }
        }

        return max;
    }
}
