package com.gzq.demo.leetcode.数组.插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        int[][] newIntervals = new int[len + 1][2];
        for (int i = 0; i < newIntervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (i != newIntervals.length - 1) {
                    newIntervals[i][j] = intervals[i][j];
                } else {
                    newIntervals[i][j] = newInterval[j];
                }
            }
        }
        Arrays.sort(newIntervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(newIntervals));
        int start = newIntervals[0][0];
        int end = newIntervals[0][1];
        result.add(new int[]{start, end});
        for (int i = 1; i < newIntervals.length; i++) {
            int[] interval = newIntervals[i];
            int temp1 = interval[0];
            int temp2 = interval[1];
            if (temp1 <= end) {
                end = Math.max(end, temp2);
                result.remove(result.size() - 1);
            } else {
                start = temp1;
                end = temp2;

            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}
