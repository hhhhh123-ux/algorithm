package com.gzq.demo.leetcode.数组.单词拆分.Solution;

import java.util.Arrays;
import java.util.List;

public class Solution {

    private int count = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < s.length(); i++) {
            count++;
            System.out.println(count);
            System.out.println(s);
            if (wordDict.contains(s.substring(0, i + 1))) {
                if (i == s.length() - 1) {
                    return true;
                }
                if (wordBreak(s.substring(i + 1), wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
