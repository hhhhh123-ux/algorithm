package com.gzq.demo.leetcode.数组.下一个排列;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>(lists);
        // 假设 lists 中有多个 List<Integer>，这里简单添加一些示例数据
        lists.add(Arrays.asList(4, 2, 2, 0, 0, 2, 3));
        lists.add(Arrays.asList(4, 2, 0, 3, 0, 2, 2));
        lists.add(Arrays.asList(4, 2, 3, 0, 0, 2, 2));
        lists.add(Arrays.asList(4, 3, 0, 0, 2, 2, 2));
        lists.add(Arrays.asList(4, 2, 2, 0, 0, 2, 3));
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

        // 打印结果
        System.out.println("最小列表为：" + lists);
    }
}

