package com.gzq.demo.leetcode.数组.全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 1, 2}));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    void backtrack(int[] nums) {
        if (nums.length == 0) {
            result.add(new LinkedList<>(temp));
            return;
        }
        int[] newArray = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            for (int j = 0, k = 0; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    newArray[k++] = nums[j];
                }
            }
            backtrack(newArray);
            temp.removeLast();
        }
    }
}
