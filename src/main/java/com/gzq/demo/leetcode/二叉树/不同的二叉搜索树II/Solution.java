package com.gzq.demo.leetcode.二叉树.不同的二叉搜索树II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> leftList = generateTreess(1, i - 1);
            List<TreeNode> rightList = generateTreess(i + 1, n);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    root = treeNode;
                    list.add(cloneTree(root));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
//        List<TreeNode> treeNodes = new Solution().generateTreess(1, 3);
//        System.out.println(treeNodes);
    }

    public List<TreeNode> generateTreess(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTreess(start, i - 1);
            List<TreeNode> rightList = generateTreess(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(cloneTree(root));
                }
            }
        }

        return list;
    }

    private TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode cloneRoot = new TreeNode(root.val);
        cloneRoot.left = cloneTree(root.left);
        cloneRoot.right = cloneTree(root.right);

        return cloneRoot;
    }

    public class TreeNode {
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
