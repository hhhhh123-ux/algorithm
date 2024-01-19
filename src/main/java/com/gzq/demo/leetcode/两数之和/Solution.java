package com.gzq.demo.leetcode.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @ProjectName: lettCode
 * @createTime: 2021/11/29 11:31
 * @title 第1题
 * @Description: 两数之和
 * @Version: 1.0
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
