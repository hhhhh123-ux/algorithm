package com.gzq.demo.leetcode.二叉树.二叉树的最大深度;

public class Solution {

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

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, Integer level) {
        if (root == null) {
            return level;
        }
        return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
    }

    public static void main(String[] args) {
          System.out.println(new Solution().maxDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
    }
}
