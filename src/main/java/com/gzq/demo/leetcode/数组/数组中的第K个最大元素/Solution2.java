package com.gzq.demo.leetcode.数组.数组中的第K个最大元素;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    Deque<Integer> deque = new LinkedList<>();

    Deque<Integer> deque2 = new LinkedList<>();

    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            while (!deque.isEmpty() && num > deque.peekLast()) {
                Integer pollLast = deque.pollLast();
                deque2.addLast(pollLast);
            }
            deque.offerLast(num);
            while (!deque2.isEmpty()) {
                Integer last = deque2.pollLast();
                if (deque.size() <= k) {
                    deque.addLast(last);
                }
            }
            while (deque.size() > k) {
                deque.pollLast();
            }
        }
        return deque.peekLast();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
