package com.gzq.demo.leetcode.每日1题.两个线段获得的最多奖品;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        int len = prizePositions.length;
        if (k * 2 + 1 >= prizePositions[len - 1] - prizePositions[0]) {
            return len;
        }
        int ans = 0;
        int left = 0;
        int[] mx = new int[len + 1];
        for (int right = 0; right < len; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, mx[left] + right - left + 1);
            mx[right + 1] = Math.max(mx[right], right - left + 1);
        }
        return ans;
    }
}
