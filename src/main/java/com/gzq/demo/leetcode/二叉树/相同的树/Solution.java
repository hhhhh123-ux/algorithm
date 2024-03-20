package com.gzq.demo.leetcode.二叉树.相同的树;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        int p_val = p.val;
        int q_val = q.val;
        if (p_val != q_val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1, new TreeNode(1), new TreeNode(2))));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, Solution.TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
