package com.gzq.demo.leetcode.二叉树.对称二叉树;

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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        if( leftRoot.val !=rightRoot.val){
            return false;
        }
        return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSymmetric(new TreeNode(1, new TreeNode(2,null,new TreeNode(3)), new TreeNode(2,null,new TreeNode(3)))));
    }

}
