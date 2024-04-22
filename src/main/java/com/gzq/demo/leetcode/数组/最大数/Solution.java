package com.gzq.demo.leetcode.数组.最大数;

public class Solution {
    public String largestNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (compare(nums[i] + "" + nums[j], nums[j] + "" + nums[i]) < 0) {
                    // nums[i] + nums[j] 比较小或相等
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int num : nums) {
            ret.append(num);
        }
        while (ret.length() > 1 && ret.charAt(0) == '0') {
            ret.deleteCharAt(0);
        }
        return ret.toString();

    }

    public int compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10, 2}));
    }
}
