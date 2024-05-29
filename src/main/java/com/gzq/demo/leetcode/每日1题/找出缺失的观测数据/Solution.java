package com.gzq.demo.leetcode.每日1题.找出缺失的观测数据;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    LinkedList<Integer> temp = new LinkedList<>();

    List<List<Integer>> result = new ArrayList<>();

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int totalSum = Arrays.stream(rolls).sum();
        int totalSize = rolls.length + n;
        int totalMean = mean * totalSize;
        int totalMissing = totalMean - totalSum;
        if (n <= totalMissing && totalMissing <= 6 * n) {
            tracking(n, totalMissing, 0);
            if (result.size() != 0) {
                for (int i = 0; i < n; i++) {
                    res[i] = result.get(0).get(i);
                }
                return res;
            }
        } else {
            return new int[]{};
        }
        return new int[]{};
    }

    public void tracking(int n, int totalMissing, int count) {
        if (result.size() != 0) {
            return;
        }
        if (count == n) {
            if (temp.stream().mapToInt(Integer::intValue).sum() == totalMissing) {
                System.out.println(temp);
                result.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        for (int i = 1; i <= 6; i++) {
            temp.add(i);
            tracking(n, totalMissing, count + 1);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().missingRolls(new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40)));
    }
}
