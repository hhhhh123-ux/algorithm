package com.gzq.demo.leetcode.每日1题.找出输掉零场或一场比赛的玩家;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    TreeMap<Integer, Integer> map1 = new TreeMap<>();

    TreeMap<Integer, Integer> map2 = new TreeMap<>();

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < matches.length; i++) {
            int[] list = matches[i];
            System.out.println(Arrays.toString(list));
            map1.put(list[0], map1.getOrDefault(list[0], 0) + 1);
            map2.put(list[1], map2.getOrDefault(list[1], 0) + 1);
        }
        System.out.println(map1);
        System.out.println(map2);
        List<Integer> list1 = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if (map2.get(key) == null) {
                list1.add(key);
            }
        }
        res.add(list1);
        List<Integer> list2 = new ArrayList<>();
        for (Integer key : map2.keySet()) {
            if (map2.get(key) != null && map2.get(key) == 1) {
                list2.add(key);
            }
        }
        res.add(list2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));
    }
}
