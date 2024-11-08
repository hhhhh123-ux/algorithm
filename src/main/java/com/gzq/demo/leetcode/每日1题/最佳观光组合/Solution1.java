package com.gzq.demo.leetcode.每日1题.最佳观光组合;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int left = values[0];
        for (int j = 1; j < values.length; j++) {
            max = Math.max(max, left + values[j] - j);
            left=Math.max(left,values[j]+j);
        }
        return max;
    }
}
