package com.gzq.demo.leetcode.数组.数组中的第K个最大元素;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {

    Deque<Integer> deque = new LinkedList<>();

    Deque<Integer> deque2 = new LinkedList<>();

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {

            if (deque.isEmpty()) {
                deque.add(nums[i]);
                continue;
            }
            Integer first = deque.peekFirst();
            if (nums[i] >= first) {
                deque.addFirst(nums[i]);
                continue;
            }
            while (deque.peekLast() < nums[i]) {
                Integer last = deque.pollLast();
                deque2.addLast(last);
            }
            deque.addLast(nums[i]);
            while (!deque2.isEmpty()) {
                Integer last = deque2.pollLast();
                deque.addLast(last);
            }

        }
        while (deque.size() > k) {
            deque.pollLast();
        }
        return deque.peekLast();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
