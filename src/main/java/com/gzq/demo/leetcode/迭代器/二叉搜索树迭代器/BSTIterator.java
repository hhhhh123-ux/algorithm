package com.gzq.demo.leetcode.迭代器.二叉搜索树迭代器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    private TreeNode root;

    private Queue<Integer> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        inorderTraversal(root);
    }

    public int next() {
        return stack.poll();
    }

    public boolean hasNext() {
        if(!stack.isEmpty()){
            return true;
        }
        return false;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        stack.add(root.val);
        inorderTraversal(root.right);
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));
        // 返回 3
        // 返回 7
        // 返回 True
        // 返回 9
        // 返回 True
        // 返回 15
        // 返回 True
        // 返回 20
        // 返回 False
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }
}
