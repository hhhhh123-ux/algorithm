package com.gzq.demo.leetcode.每日1题.坐上公交的最晚时间;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {

        System.out.println(new Solution1().latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // 对班车和乘客的到达时间进行排序
        Arrays.sort(buses);
        Arrays.sort(passengers);
        // 模拟乘客上车
        int passengerIndex = 0;
        int availableCapacity = capacity;
        for (int busTime : buses) {
            availableCapacity = capacity;  // 初始化容量
            while (availableCapacity > 0 && passengerIndex < passengers.length && passengers[passengerIndex] <= busTime) {
                passengerIndex++;
                availableCapacity--;
            }
        }
        // 寻找可以插队的最晚时间
        passengerIndex--;
        // 如果最后一辆车没有满，最晚的上车时间就是最后一辆车的出发时间，否则是最后一个上车乘客的时间
        int latestTime = (availableCapacity > 0) ? buses[buses.length - 1] : passengers[passengerIndex];
        // 向前寻找一个不与乘客时间重合的最晚上车时间
        while (passengerIndex >= 0 && latestTime == passengers[passengerIndex]) {
            latestTime--;
            passengerIndex--;
        }
        return latestTime;
    }
}

