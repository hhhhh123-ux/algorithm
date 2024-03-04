package com.gzq.demo.leetcode.二叉树.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //左 根 右
        List<Integer> list = new ArrayList<>();
        list=Traversal(root,list);
        return list;
    }

    //
    public List<Integer> Traversal(TreeNode root,List<Integer> list) {
        //左 根 右
        if (root != null) {
            Traversal(root.left,list);
            list.add(root.val);
            Traversal(root.right,list);
        }
        return list;
    }

    public  static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().inorderTraversal(root));
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
