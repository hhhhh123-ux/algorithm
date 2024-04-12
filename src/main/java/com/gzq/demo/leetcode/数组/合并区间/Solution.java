package com.gzq.demo.leetcode.数组.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int m = intervals.length;
        int n = intervals[0].length;
        n = 2;
        // 使用自定义的比较器按照区间的起始位置进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // 按照起始位置升序排序
            }
        });
        System.out.println(Arrays.deepToString(intervals));
        int start = 0;
        int end = 0;
        for (int i = 0; i < m; i++) {
            int[] interval = intervals[i];
            int temp1 = interval[0];
            int temp2 = interval[1];
            if (i == 0) {
                start = temp1;
                end = temp2;
                result.add(new int[]{start, end});
            } else {
                if (temp1 <= end) {
                    end = Math.max(end, temp2);
                    result.remove(result.size() - 1);
                    result.add(new int[]{start, end});
                } else {
                    start = temp1;
                    end = temp2;
                    result.add(new int[]{start, end});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{{1, 3}, {2, 6}, {10, 15}, {14, 18}})));
    }
}