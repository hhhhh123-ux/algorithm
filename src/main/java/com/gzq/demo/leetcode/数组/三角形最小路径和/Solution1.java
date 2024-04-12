package com.gzq.demo.leetcode.数组.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0) {
                    continue;
                } else {
                    dp[i][j] = triangle.get(i).get(j);
                    if (j == 0) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j];
                    } else if (j == triangle.get(i).size() - 1) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }
        }
        int[] dd=dp[triangle.size()-1];
        Arrays.sort(dd);
        return dd[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().minimumTotal(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2));
            add(Arrays.asList(3, 4));
            add(Arrays.asList(6, 5, 7));
            add(Arrays.asList(4, 1, 8, 3));
        }}));
    }
}
