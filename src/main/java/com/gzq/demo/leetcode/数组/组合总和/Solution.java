package com.gzq.demo.leetcode.数组.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{8, 7, 4, 3}, 11));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);
        return result;
    }


    void backtracking(int[] candidates, int begin, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            temp.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i]);
            temp.removeLast();
        }
    }

}
