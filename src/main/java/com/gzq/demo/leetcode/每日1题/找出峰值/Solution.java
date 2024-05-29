package com.gzq.demo.leetcode.每日1题.找出峰值;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i + 1] && mountain[i] > mountain[i - 1]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeaks(new int[]{2, 1, 1}));
    }
}
