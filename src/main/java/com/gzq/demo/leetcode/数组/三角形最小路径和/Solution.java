package com.gzq.demo.leetcode.数组.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> dp = new ArrayList<>();

    LinkedList<Integer> temp = new LinkedList<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        packtracking(triangle, 0, 0);
        Integer[] dpArray = dp.toArray(new Integer[0]);
        Arrays.sort(dpArray);
        return dpArray[0];
    }

    public void packtracking(List<List<Integer>> triangle, int index, int step) {
        if (index == triangle.size()) {
            result.add(new ArrayList<>(temp));
            dp.add(sumLinkedList(temp));
            return;
        }
        for (int i = step; i <= step + 1; i++) {
            if (i >= triangle.get(index).size()) {
                break;
            }
            temp.add(triangle.get(index).get(i));
            packtracking(triangle, index + 1, i);
            temp.removeLast();


        }
    }

    public int sumLinkedList(LinkedList<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTotal(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2));
            add(Arrays.asList(3, 4));
            add(Arrays.asList(6, 5, 7));
            add(Arrays.asList(4, 1, 8, 3));
        }}));
    }
}
