package com.gzq.demo.leetcode.数组.全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionII {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums);
        result=result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    void backtrack(int[] nums) {
       
    }
}
