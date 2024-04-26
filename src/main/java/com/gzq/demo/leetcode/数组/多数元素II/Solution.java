package com.gzq.demo.leetcode.数组.多数元素II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
