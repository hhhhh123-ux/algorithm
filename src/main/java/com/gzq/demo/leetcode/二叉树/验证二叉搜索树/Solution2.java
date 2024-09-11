package com.gzq.demo.leetcode.二叉树.验证二叉搜索树;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().isValidBST(new Solution2.TreeNode(5, new Solution2.TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        // 递归终止条件
        if (root == null) {
            return true;
        }

        int val = root.val;

        // 检查当前节点值是否在合法范围内
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }

        // 递归检查左子树，此时上界为当前节点值 val
        // 递归检查右子树，此时下界为当前节点值 val
        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
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
