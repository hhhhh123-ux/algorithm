package com.gzq.demo.leetcode.滑动窗口.至少有K个重复字符的最长子串;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(new Solution4().longestSubstring("ababbc", 2));
    }

    private static int longestSubstringWithNUniqueChars(String s, int k, int uniqueTarget) {
        int[] charCount = new int[26]; // 存储当前窗口内字符的出现次数
        int left = 0, right = 0;       // 滑动窗口的左右指针
        int unique = 0;                // 当前窗口内不同字符的数量
        int countAtLeastK = 0;         // 当前窗口内至少出现 k 次的字符数量
        int maxLen = 0;

        // 开始滑动窗口
        while (right < s.length()) {
            // 处理右边界字符
            if (charCount[s.charAt(right) - 'a'] == 0) {
                unique++; // 发现新字符
            }
            charCount[s.charAt(right) - 'a']++;
            if (charCount[s.charAt(right) - 'a'] == k) {
                countAtLeastK++; // 该字符满足出现至少k次
            }
            right++;

            // 调整左边界，确保窗口内不同字符数量不超过 uniqueTarget
            while (unique > uniqueTarget) {
                if (charCount[s.charAt(left) - 'a'] == k) {
                    countAtLeastK--; // 减少满足k次的字符数量
                }
                charCount[s.charAt(left) - 'a']--;
                if (charCount[s.charAt(left) - 'a'] == 0) {
                    unique--; // 移除字符
                }
                left++;
            }

            // 如果当前窗口内所有字符都至少出现了k次，更新最大长度
            if (unique == countAtLeastK) {
                maxLen = Math.max(maxLen, right - left);
            }
        }

        return maxLen;
    }

    public int longestSubstring(String s, int k) {
        int res = 0;
        // 尝试不同数量的不同字符，最多不超过26个小写字母
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            // 调用滑动窗口方法，查找当前限制不同字符数量下的最大长度
            res = Math.max(res, longestSubstringWithNUniqueChars(s, k, uniqueTarget));
            System.out.println("uniqueTarget==" + uniqueTarget + "\n" + "res==" + res);
        }
        return res;
    }
}
