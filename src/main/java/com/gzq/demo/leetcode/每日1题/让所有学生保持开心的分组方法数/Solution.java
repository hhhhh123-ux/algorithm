package com.gzq.demo.leetcode.每日1题.让所有学生保持开心的分组方法数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 7, 1, 2, 2, 4, 7));
        System.out.println(new Solution().countWays(list));
    }

    public int countWays(List<Integer> nums) {
        int count = 0;
        int len = nums.size();
        Collections.sort(nums);
        for (int i = 0; i < len + 1; i++) {
            if (i == 0) {
                if (i < nums.get(0)) {
                    count++;
                }
            } else if (i == len) {
                if (i > nums.get(len - 1)) {
                    count++;
                }
            } else {

                if (nums.get(i - 1) < i && i < nums.get(i)) {
                    count++;
                }
            }
        }
        return count;
    }
}
