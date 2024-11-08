package com.gzq.demo.leetcode.每日1题.预算内的最多机器人数目;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumRobots(new int[]{3, 6, 1, 3, 4}, new int[]{2, 1, 3, 4, 5}, 25));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int count = 0;
        int maxTime = 0;
        for (int i = 0; i < chargeTimes.length; i++) {
            maxTime = Math.max(maxTime, chargeTimes[i]);
            int sum = 0;
            for (int j = 0; j < i + 1; j++) {
                sum = runningCosts[j] + sum;
            }
            if (maxTime + (i + 1) * sum < budget) {
                count++;
            }
        }

        return count;
    }
}
