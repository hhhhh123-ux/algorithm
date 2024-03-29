package com.gzq.demo.leetcode.数组.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Long targetLong = Long.valueOf(target);
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int a = 0; a < length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            Long sum = (long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
            if (sum > targetLong) {
                break;
            }
            for (int b = a + 1; b < length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                Long sum1 = (long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2];
                if (sum1 > targetLong) {
                    break;
                }
                int left = b + 1;
                int right = length - 1;
                while (left > b && right > left) {
                    Long sum2 = (long) nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum2 == targetLong) {
                        lists.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum2 < targetLong) {
                        left++;
                    } else if (sum2 > targetLong) {
                        right--;
                    }
                }
            }
        }
        lists = lists.stream().distinct().collect(Collectors.toList());
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }
}
