package com.gzq.demo.leetcode.滑动窗口.重复的DNA序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * 187. 重复的DNA序列
     * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
     * 例如，"ACGAATTCCG" 是一个 DNA序列 。
     * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
     * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashMap hashMap = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (hashMap.containsKey(sub)) {
                if(!list.contains(sub)){
                    list.add(sub);
                }
            } else {
                hashMap.put(sub, 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
