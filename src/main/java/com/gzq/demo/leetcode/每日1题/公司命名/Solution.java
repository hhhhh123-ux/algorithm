package com.gzq.demo.leetcode.每日1题.公司命名;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }

    public long distinctNames(String[] ideas) {

        Set<String> originalSet = new HashSet<>();
        for (String idea : ideas) {
            originalSet.add(idea);
        }

        long count = 0;
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                System.out.println("start /////////////");
                String left = ideas[i];
                String right = ideas[j];
                System.out.println("left:" + left + " " + "right:" + right);
                char firstCharLeft = left.charAt(0);
                char firstCharRight = right.charAt(0);
                String leftWithoutFirstChar = left.substring(1);
                String rightWithoutFirstChar = right.substring(1);
                String left1 = firstCharRight + leftWithoutFirstChar;
                String right1 = firstCharLeft + rightWithoutFirstChar;
                System.out.println("left1:" + left1 + " " + "right1:" + right1);

                if (!originalSet.contains(left1) && !originalSet.contains(right1)) {
                    count += 2;
                }
                System.out.println("end /////////////");
            }
        }
        return count;
    }
}
