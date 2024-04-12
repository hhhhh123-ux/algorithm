package com.gzq.demo.leetcode.数组.子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        System.out.println(result);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, i + 1);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1, 2, 3});
    }
}
