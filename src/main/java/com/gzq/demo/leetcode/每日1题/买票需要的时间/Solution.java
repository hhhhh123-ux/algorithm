package com.gzq.demo.leetcode.每日1题.买票需要的时间;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        Queue<Map<Integer, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = null;
        for (int i = 0; i < tickets.length; i++) {
            map = new HashMap<>();
            map.put(i, tickets[i]);
            queue.add(map);
        }
        while (!queue.isEmpty()) {
            Map<Integer, Integer> head = queue.poll();
            if (head != null && head.size() == 1) {
                int key = head.keySet().iterator().next();
                int value = head.get(key);
                if (key == k && value == 1) {
                    count++;
                    return count;
                }
                value--;
                count++;
                if(value!=0){
                    head.put(key, value);
                    queue.add(head);
                }

            }
        }
        return count;
    }
}
