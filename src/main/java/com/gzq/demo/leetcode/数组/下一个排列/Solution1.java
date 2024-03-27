package com.gzq.demo.leetcode.数组.下一个排列;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    /**
     * 下一个排列
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int[] dp = Arrays.copyOfRange(nums, 0, nums.length);
                    int temp = dp[i];
                    dp[i] = dp[j];
                    dp[j] = temp;
                    Arrays.sort(dp, j + 1, nums.length);
                    List<Integer> list = Arrays.asList(Arrays.stream(dp).boxed().toArray(Integer[]::new));
                    lists.add(list);
                }
            }
        }
        if (lists.size() > 0) {
            System.out.println("lists==" + lists);
            Set<List<Integer>> set = new HashSet<>(lists);
            lists.clear();
            lists.addAll(set);
            // 使用循环筛选出每个位置上最小的值，直到只有一个列表
            while (lists.size() > 1) {
                // 按照第一位数字筛选最小值
                int minFirst = lists.stream().mapToInt(list -> list.get(0)).min().orElse(Integer.MAX_VALUE);
                List<List<Integer>> minFirstLists = lists.stream().filter(list -> list.get(0) == minFirst).collect(Collectors.toList());
                // 如果只有一条列表，就直接退出循环
                if (minFirstLists.size() == 1) {
                    lists = minFirstLists;
                    break;
                }
                // 按照第二位数字筛选最小值
                int minSecond = minFirstLists.stream().mapToInt(list -> list.get(1)).min().orElse(Integer.MAX_VALUE);
                List<List<Integer>> minSecondLists = minFirstLists.stream().filter(list -> list.get(1) == minSecond).collect(Collectors.toList());
                // 如果只有一条列表，就直接退出循环
                if (minSecondLists.size() == 1) {
                    lists = minSecondLists;
                    break;
                }
                // 以此类推，按照后面的数字筛选最小值
                for (int i = 2; i < minSecondLists.get(0).size(); i++) {
                    int index = i;
                    int min = minSecondLists.stream().mapToInt(list -> list.get(index)).min().orElse(Integer.MAX_VALUE);
                    minSecondLists = minSecondLists.stream().filter(list -> list.get(index) == min).collect(Collectors.toList());
                    if (minSecondLists.size() == 1) {
                        lists = minSecondLists;
                        break;
                    }
                }
            }
            System.out.println("lists==" + lists);
            if (lists.size() == 1) {
                int length = lists.get(0).size();
                for (int i = 0; i < length; i++) {
                    nums[i] = lists.get(0).get(i);
                }
            }
        } else {
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution1().nextPermutation(new int[]{2, 3, 1, 3, 3});
    }
}
