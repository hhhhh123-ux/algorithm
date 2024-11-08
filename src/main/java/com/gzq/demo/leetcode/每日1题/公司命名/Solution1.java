package com.gzq.demo.leetcode.每日1题.公司命名;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }

    public long distinctNames(String[] ideas) {
        Set<String> distinctCount = new HashSet<>();
        Set<String> originalSet = new HashSet<>();
        Set<String>[] groups = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            groups[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            originalSet.add(idea);
            int index = idea.charAt(0) - 'a';
            groups[index].add(idea.substring(1));
        }

        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String left = ideas[i];
                String right = ideas[j];
                char firstCharLeft = left.charAt(0);
                char firstCharRight = right.charAt(0);
                int leftIndex = firstCharLeft - 'a';
                int rightIndex = firstCharRight - 'a';

                String left1 = firstCharRight + left.substring(1);
                String right1 = firstCharLeft + right.substring(1);
                System.out.println(left1 + " " + right1);
                if (!originalSet.contains(left1) && !groups[rightIndex].contains(left.substring(1)) && !originalSet.contains(right1) && !groups[leftIndex].contains(right.substring(1))) {
                    distinctCount.add(left1 + " " + right1);
                }
            }
        }
        return distinctCount.size() * 2;
    }
}
