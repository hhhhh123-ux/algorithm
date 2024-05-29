package com.gzq.demo.leetcode.每日1题.找出缺失的观测数据;

import java.util.Arrays;

public class Solution1 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int totalSum = Arrays.stream(rolls).sum();
        int totalSize = rolls.length + n;
        int totalMean = mean * totalSize;
        int totalMissing = totalMean - totalSum;
        if (n <= totalMissing && totalMissing <= 6 * n) {
            int avg = totalMissing / n;
            int mod = totalMissing % n;
            Arrays.fill(res, avg);
            int kong = 6 - avg;
            while (mod > 0) {
                if (mod < kong) {
                    res[n - mod] = res[n - mod] + mod;
                    mod = mod - mod;
                }else{
                    res[n - mod] = res[n - mod] + kong;
                    mod = mod - kong;
                }
            }
            return res;
        } else {
            return new int[]{};
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().missingRolls(new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40)));
    }
}
