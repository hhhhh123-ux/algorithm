package com.gzq.demo.leetcode.二叉树.从中序与后序遍历序列构造二叉树;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIndex = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - inStart;
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftLength - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + leftLength, postEnd - 1);
        return root;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
