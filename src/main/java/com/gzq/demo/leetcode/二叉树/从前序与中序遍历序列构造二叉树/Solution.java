package com.gzq.demo.leetcode.二叉树.从前序与中序遍历序列构造二叉树;

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

        public TreeNode(int val, Solution.TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - inStart;
        // 递归构建左右子树
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftLength, inStart, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + leftLength + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
