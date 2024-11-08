package com.gzq.demo.leetcode.每日1题.预算内的最多机器人数目;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().maximumRobots(new int[]{3, 6, 1, 3, 4}, new int[]{2, 1, 3, 4, 5}, 25));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (right = 0; right < chargeTimes.length; right++) {
            if (!q.isEmpty() && chargeTimes[q.peekLast()] < chargeTimes[right]) {
                q.pollLast();
            }
            q.add(right);
            sum += runningCosts[right];

            while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (right - left + 1) * sum > budget) {
                if (q.peekFirst() == left) {
                    q.pollFirst();
                }
                sum -= runningCosts[left++];
            }
            count = Math.max(count, right - left + 1);

        }
        return count;
    }
}
