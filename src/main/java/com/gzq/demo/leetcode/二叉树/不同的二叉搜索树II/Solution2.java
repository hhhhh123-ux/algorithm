package com.gzq.demo.leetcode.二叉树.不同的二叉搜索树II;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

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


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            for (int j = 1; j <= i; j++) {

            }
        }
        return list;
    }

}



