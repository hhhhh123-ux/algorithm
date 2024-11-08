package com.gzq.demo.leetcode.每日1题.执行操作可获得的最大总奖励I;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int mx = rewardValues[n - 1];

        boolean[] f = new boolean[2 * mx];
        Arrays.fill(f, false);
        f[0] = true;
        int ans = 0;
        for (int x : rewardValues) {
            for (int j = x; j <= 2 * x - 1; j++) {
                if (f[j] || f[j - x]) {
                    f[j] = true;
                    ans = Math.max(ans, j);
                }
            }
        }
        return ans;
    }
}
