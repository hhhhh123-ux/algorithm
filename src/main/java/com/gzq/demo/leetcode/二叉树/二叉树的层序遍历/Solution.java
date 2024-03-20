package com.gzq.demo.leetcode.二叉树.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    Integer sto;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        int val = root.val;
        List<Integer> list = new ArrayList<>();
        list.add(val);
        result.add(list);
        levelOrder(root, 1);
        for (int i = result.size() - 1; i > 0; i--) {
            if (result.get(i).size() == 0) {
                result.remove(i);
            }
        }
        return result;
    }

    public void levelOrder(TreeNode root, int storey) {
        sto = storey;
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            result.add(list);
            if (root.left != null) {

                int leftVal = root.left.val;
                result.get(storey).add(leftVal);
            }
            if (root.right != null) {
                int rightVal = root.right.val;
                result.get(storey).add(rightVal);
            }

            if (root.left != null) {
                levelOrder(root.left, storey + 1);
            }
            if (root.right != null) {
                levelOrder(root.right, storey + 1);

            }

        }

    }

    public static void main(String[] args) {
        //System.out.println(new Solution().levelOrder(new TreeNode(1)));
        //System.out.println(new Solution().levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        //System.out.println(new Solution().levelOrder(new TreeNode(1, new TreeNode(2), null)));
        //System.out.println(new Solution().levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null)));
        //System.out.println(new Solution().levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)))));
        System.out.println(new Solution().levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
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

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
