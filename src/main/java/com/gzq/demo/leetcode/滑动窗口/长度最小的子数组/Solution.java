package com.gzq.demo.leetcode.滑动窗口.长度最小的子数组;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author
 * @ProjectName: lettCode
 * @createTime: 2021/11/29 11:31
 * @title 第209题
 * @Description: 长度最小的子数组
 * @Version: 1.0
 */
public class Solution {
    /**
     * @param target
     * @param nums
     * @return
     * @description: 暴力破解
     */
    public static int minSubArrayLen(int target, int[] nums) {
        long start = System.currentTimeMillis(); // 记录开始时间
        // 这里写需要测试运行时间的代码
        int count = 0;
        int len = nums.length;
        if (len == 0) {
            return count;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum >= target) {
                count = 1;
                return count;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums[j] >= target) {
                    count = 1;
                    return count;
                }
                sum += nums[j];
                if (sum >= target) {
                    count = j - i + 1;
                    map.put(i, count);
                    break;
                }

            }
        }
        if (map.size() > 0) {
            count = Collections.min(map.values());
            return count;
        }
        long end = System.currentTimeMillis(); // 记录结束时间
        long duration = end - start; // 计算运行时间差值（单位为毫秒）
        System.out.println("程序运行时间1：" + duration + "ms");
        return 0;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = new int[]{1, 1, 1, 1, 1};
//        System.out.println(minSubArrayLen(target, nums));
//        System.out.println(minSubArrayLen2(target, nums));
        System.out.println(minSubArrayLen3(target, nums));
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        long start = System.currentTimeMillis(); // 记录开始时间
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        long end = System.currentTimeMillis(); // 记录结束时间
        long duration = end - start; // 计算运行时间差值（单位为毫秒）
        System.out.println("程序运行时间2：" + duration + "ms");
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen3(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left < len) {
            left += left;
            sum += nums[left];
            while (sum >= target) {
                count = Math.min(count, left - right);
                right+=right;
                sum -= nums[right];
            }
        }
        System.out.println(count);
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
