package com.gzq.demo.leetcode.每日1题.找出最具竞争力的子序列;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1 {

    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() - 1 + nums.length - i >= k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().mostCompetitive(new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71}, 24)));
    }
}
