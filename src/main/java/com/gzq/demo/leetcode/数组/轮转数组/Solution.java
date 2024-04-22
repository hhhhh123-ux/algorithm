package com.gzq.demo.leetcode.数组.轮转数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    Queue<String> queue = new LinkedList<>();

    public void rotate(int[] nums, int k) {
        for (int i = nums.length - 1; i >= 0; i--) {
            queue.add(String.valueOf(nums[i]));
        }
        while (k > 0) {
            String p = queue.peek();
            queue.poll();
            queue.add(p);
            k--;
        }
        System.out.println(queue);
        for (int i = nums.length - 1; i >=0; i--) {
            nums[i] = Integer.parseInt(queue.poll());
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2}, 3);
    }
}
