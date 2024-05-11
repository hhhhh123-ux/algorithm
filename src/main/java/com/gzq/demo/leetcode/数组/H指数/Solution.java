package com.gzq.demo.leetcode.数组.H指数;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int n = citations.length;
        int h = 0;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, Math.min(citations[i], n - i));
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
