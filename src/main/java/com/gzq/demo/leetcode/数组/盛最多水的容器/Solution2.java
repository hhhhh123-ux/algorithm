package com.gzq.demo.leetcode.数组.盛最多水的容器;

public class Solution2 {
    public int maxArea(int[] height) {
        int area = 0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            int leftRight = Math.min(leftHeight, rightHeight);
            area = Math.max(area, (right-left)*leftRight);
            if (leftHeight<rightHeight){
                left++;
            }else {
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
