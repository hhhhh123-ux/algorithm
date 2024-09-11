package com.gzq.demo.leetcode.每日1题.让所有学生保持开心的分组方法数;

import java.util.Collections;
import java.util.List;

public class Solution1 {


    public int countWays(List<Integer> nums) {
        int count = 0;
        int len = nums.size();

        // 对nums进行排序
        Collections.sort(nums);

        // 检查0是否可以作为符合条件的数
        if (0 < nums.get(0)) {
            count++;
        }

        // 检查每个位置是否可以成为符合条件的数
        for (int i = 1; i < len; i++) {
            if (nums.get(i - 1) < i && i < nums.get(i)) {
                count++;
            }
        }

        // 检查len是否可以作为符合条件的数
        if (len > nums.get(len - 1)) {
            count++;
        }

        return count;
    }

}
