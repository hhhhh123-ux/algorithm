package com.gzq.demo.leetcode.二叉树.二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzagLevelOrder(root, 0);
        return result;
    }

    public void zigzagLevelOrder(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }
        if (level <= result.size()) {
            int val = root.val;
            list = new ArrayList<>();

            if (level % 2 == 0) {
                if (level < result.size()) {
                    result.get(level).add(val);
                } else {
                    result.add(list);
                    result.get(level).add(val);
                }

            } else if (level % 2 == 1) {
                if (level < result.size()) {
                    result.get(level).add(0, val);
                } else {
                    result.add(list);
                    result.get(level).add(0, val);
                }
            }
        }
        zigzagLevelOrder(root.left, level + 1);
        zigzagLevelOrder(root.right, level + 1);
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().zigzagLevelOrder(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
        //System.out.println(new Solution().zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(new Solution().zigzagLevelOrder(new TreeNode(1)));

    }
}
