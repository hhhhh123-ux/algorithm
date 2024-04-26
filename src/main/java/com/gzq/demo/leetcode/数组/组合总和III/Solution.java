package com.gzq.demo.leetcode.数组.组合总和III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> temp = new LinkedList<>();

    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public List<List<Integer>> combinationSum3(int k, int n) {
        System.out.println(nums);
        backtracking(nums, k, n, 0);
        return result;
    }


    public void backtracking(List<Integer> nums, int k, int n, int begin) {
        if (temp.size() == k) {
            if (temp.stream().mapToInt(Integer::intValue).sum() == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = begin; i < nums.size(); i++) {
            temp.add(nums.get(i));
            backtracking(nums, k, n, i + 1);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
