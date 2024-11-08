package com.gzq.demo.leetcode.每日1题.坐上公交的最晚时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{3}, new int[]{2, 4}, 2));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int count = 0;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        List<Integer> integers = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < buses.length; i++) {
            int buse = buses[i];
            int buseCount = capacity;
            for (int j = 0; j < passengers.length; j++) {
                List<Integer> list = hashMap.getOrDefault(buse, new ArrayList<>());
                int pass = passengers[j];
                if (pass < buse && !integers.contains(pass)) {
                    if (i + 1 == buses.length && list.size() == 1) {
                        if (pass < buse && pass > list.get(0)) {
                            count = list.get(0) - 1;
                            return count;
                        }
                    }
                    integers.add(pass);
                    list.add(pass);
                    hashMap.put(buse, list);
                }

            }
        }
        return count;
    }
}
