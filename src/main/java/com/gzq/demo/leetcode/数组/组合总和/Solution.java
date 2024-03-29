package com.gzq.demo.leetcode.数组.组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target);
        return result;
    }


    void backtracking(int[] candidates, int target) {
        if (result.size()<150) {
            return;
        }
    }

}
