package com.gzq.demo.leetcode.数组.单词拆分;

import com.gzq.demo.leetcode.数组.单词拆分.Solution.Solution;

import java.util.*;

public class Solution1 {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
