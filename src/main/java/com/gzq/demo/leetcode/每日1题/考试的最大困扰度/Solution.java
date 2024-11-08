package com.gzq.demo.leetcode.每日1题.考试的最大困扰度;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutiveAnswers("TFFT", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int countT = 0;
        int countF = 0;
        int maxLen = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }

            while (Math.min(countF, countT) > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
