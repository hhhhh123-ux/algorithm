package com.gzq.demo.leetcode.每日1题.找出最具竞争力的子序列;


import java.util.*;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> temp = new LinkedList<>();


    /*
     * 1. 暴力法
     * 2. 递归
     * 3. 贪心
     * 4. 堆
     * 5. 栈
     * 6. 递推
     * 7. 递归+记忆化
     * 8. 递归+分治
     * 9. 递归+回溯
     * 10. 递归+剪枝
     * 11. 递归+动态规划
     * 12. 递归+分治+动态规划
     */
    public int[] mostCompetitive(int[] nums, int k) {
        int[] result1 = new int[k];
        tracking(nums, 0, k);
        System.out.println(result);
        for (int i = 0; i < result.get(0).size(); i++) {
            result1[i] = result.get(0).get(i);
        }
        return result1;
    }

    public void tracking(int[] nums, int begin, int k) {
        if (temp.size() == k) {
            if (!result.isEmpty()) {
                List<Integer> list = result.get(0);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < temp.get(i)) {
                        return;
                    } else if (list.get(i) > temp.get(i)) {
                        result.clear();
                        result.add(new ArrayList<>(temp));
                        return;
                    }
                }
            } else {
                result.add(new ArrayList<>(temp));
                return;
            }
        }

        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            tracking(nums, i + 1, k);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71}, 24)));
    }
}
