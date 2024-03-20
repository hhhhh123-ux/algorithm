package com.gzq.demo.leetcode.二叉树.恢复二叉搜索树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public void recoverTree(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        while (!isValidBST(root, map)) {
            printTreeNodes(root, map);
            map.remove("val");
            map.remove("leftVal");
            map.remove("rightVal");
        }
    }

    void printTreeNodes(TreeNode node, Map<String, Integer> map) {
        if (node == null) return;
        int val = node.val;
        if (val == map.get("val")) {
            if (map.get("leftVal") != null) {
                node.val = map.get("leftVal");
            } else if (map.get("rightVal") != null) {
                node.val = map.get("rightVal");
            }
        }
        if ((map.get("leftVal") != null && val == map.get("leftVal")) || map.get("rightVal") != null && val == map.get("rightVal")) {
            node.val = map.get("val");
        }
        printTreeNodes(node.left, map); // 遍历左子树
        printTreeNodes(node.right, map); // 遍历右子树
    }

    public boolean isValidBST(TreeNode root, Map<String, Integer> map) {
        return isValidBST(root, null, null, map);
    }

    public boolean isValidBST(TreeNode root, Integer leftVal, Integer rightVal, Map<String, Integer> map) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (leftVal != null && val <= leftVal) {
            map.put("val", val);
            map.put("leftVal", leftVal);
            return false;
        }
        if (rightVal != null && val >= rightVal) {
            map.put("val", val);
            map.put("rightVal", rightVal);
            return false;
        }
        return isValidBST(root.left, leftVal, val, map) && isValidBST(root.right, val, rightVal, map);
    }


    public static void main(String[] args) {
        new Solution().recoverTree(new TreeNode(2, new TreeNode(3), new TreeNode(1)));
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
