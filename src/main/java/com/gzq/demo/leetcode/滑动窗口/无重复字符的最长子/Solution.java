package com.gzq.demo.leetcode.滑动窗口.无重复字符的最长子;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @ProjectName: lettCode
 * @createTime: 2021/11/29 11:31
 * @title 第3题
 * @Description: 无重复的最长子
 * @Version: 1.0
 */
public class Solution {

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        if (s == null || s.length() == 0 || s.equals("")) {
            return count;
        }
        if (s.length() == 1) {
            return 1;
        }
        String[] arr = s.split("");
        String str1 = "";
        for (int i = 0; i < arr.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = i + 0; j < arr.length - 1; j++) {
                String a = arr[j];
                String b = arr[j + 1];
                if (!a.equals(b)) {
                    // 检查 a 是否包含在新字符串中
                    if (!builder.toString().contains(a)) {
                        builder.append(a);
                    }
                    // 检查 b 是否包含在新字符串中
                    if (!builder.toString().contains(b)) {
                        builder.append(b);
                    } else if (builder.toString().contains(b)) {
                        break;
                    }
                    str1 = builder.toString();
                } else if (a.equals(b)) {
                    if (!a.isEmpty() && !builder.toString().contains(a)) {
                        builder.append(a);
                        str1 = builder.toString();
                    }
                    break;
                }
            }
            int length = str1.length();
            // 更新最大长度
            count = Math.max(count, length);
        }
        System.out.println("Maximum Length: " + count);
        return count;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int count = lengthOfLongestSubstring3(s);
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}