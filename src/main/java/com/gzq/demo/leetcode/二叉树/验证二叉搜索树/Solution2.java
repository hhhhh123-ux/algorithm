package com.gzq.demo.leetcode.二叉树.验证二叉搜索树;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        int val = root.val;
        return isValidBST(root, val);
    }

    public boolean isValidBST(TreeNode root, int rootVal) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (root.left != null && root.left.val >= val && rootVal >= val) {
            return false;
        }
        if (root.right != null && root.right.val <= val && rootVal <= val) {
            return false;
        }
        return isValidBST(root.left, rootVal) && (isValidBST(root.right, rootVal));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isValidBST(new Solution2.TreeNode(5, new Solution2.TreeNode(4), new TreeNode(6))));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
