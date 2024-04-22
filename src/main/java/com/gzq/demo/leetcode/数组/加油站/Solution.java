package com.gzq.demo.leetcode.数组.加油站;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for (int i = 0; i < len; i++) {
            int start = i;
            // sum 油量
            int sum = gas[start] - cost[start];
            if (sum < 0) {
                continue;
            }
            for (int j = start; j < len; j++) {
                if (j == len - 1 && start != 0) {
                    break;
                } else if (j == len - 1 && start == 0) {
                    return start;
                }
                sum = sum + gas[j + 1] - cost[j + 1];
                if (sum >= 0) {
                    if (j == len - 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (sum < 0) {
                break;
            }
            for (int j = 0; j < start; j++) {
                sum += gas[j] - cost[j];
                if (sum < 0) {
                    break;
                } else {
                    if (j == start - 1) {
                        return start;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66}, new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26}));
    }
}
