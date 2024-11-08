package com.gzq.demo.leetcode.每日1题.找到连续赢K场比赛的第一位玩家;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
    }

    public int findWinningPlayer(int[] skills, int k) {

        int m = Arrays.stream(skills).max().getAsInt();
        int player = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < skills.length; i++) {
            deque.add(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!deque.isEmpty()) {
            Integer first = deque.removeFirst();
            Integer second = deque.removeFirst();
            if (skills[first] > skills[second]) {
                deque.addFirst(first);
                deque.addLast(second);
                map.put(first, map.getOrDefault(first, 0) + 1);
                map.put(second, 0);
            } else if (skills[first] < skills[second]) {
                deque.addFirst(second);
                deque.addLast(first);
                map.put(second, map.getOrDefault(second, 0) + 1);
                map.put(first, 0);
            }
            while (map.get(first) == k || skills[first] ==m) {
                return first;
            }
            while (map.get(second) == k || skills[first] ==m) {
                return second;
            }
        }
        return player;
    }
}
