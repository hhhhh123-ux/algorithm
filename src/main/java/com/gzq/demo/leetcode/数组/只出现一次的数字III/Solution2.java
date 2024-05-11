package com.gzq.demo.leetcode.数组.只出现一次的数字III;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    Queue<Integer> queue = new LinkedList<>();

    public int[] singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (queue.contains(nums[i])) {
                queue.remove(nums[i]);
            } else {
                queue.add(nums[i]);
            }
        }
        return new int[]{queue.poll(), queue.poll()};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
