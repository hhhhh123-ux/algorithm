package com.gzq.demo.leetcode.数组.除自身以外数组的乘积;

import java.util.Arrays;

public class Solution2 {

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0]=1;
        for (int i = 1; i < nums.length; i++) {
           answer[i]=answer[i-1]*nums[i-1];
        }
        int R = 1;
        for(int i=nums.length-1;i>=0;i--){
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
