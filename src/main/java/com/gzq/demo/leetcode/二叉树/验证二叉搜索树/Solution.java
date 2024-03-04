package com.gzq.demo.leetcode.二叉树.验证二叉搜索树;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        Boolean flag = true;
        int val = root.val;
        if (root != null) {
            // 左子节点
            if (root.left != null) {
                flag = isValidBSTLeft(root.left, val);
                if(!flag){
                    return false;
                }
                if (root.left.val >= root.val) {
                    flag = false;
                    System.out.println("boolean5==" + flag);
                    return false;
                }
            }
            // 右子节点
            if (root.right != null) {
                flag = isValidBSTRight(root.right, val);
                if(!flag){
                    return false;
                }
                if (root.right.val <= root.val) {
                    flag = false;
                    System.out.println("boolean6==" + flag);
                    return false;
                }
            }
        }
        return flag;
    }

    public boolean isValidBSTLeft(TreeNode root, int val) {

        Boolean flag = true;
        flag = isValidBST(root);
        if (!flag) {
            return false;
        }
        if (root != null) {
            if (root.val >= val) {
                return false;
            }
            // 左子节点
            if (root.left != null) {
                flag = isValidBSTLeft(root.left, val);
                if (!flag) {
                    return false;
                }
                if (root.val >= val && root.left.val >= root.val) {
                    System.out.println(root.val);
                    flag = false;
                    System.out.println("boolean1==" + flag);
                    return false;
                }
            }
            //
            if (root.right != null) {
                flag = isValidBSTLeft(root.right, val);
                if (!flag) {
                    return false;
                }
                if (root.val <= val && root.right.val <= root.val) {
                    flag = false;
                    System.out.println("boolean2==" + flag);
                    return false;
                }
            }
        }
        return flag;
    }

    public boolean isValidBSTRight(TreeNode root, int val) {
        Boolean flag = true;
        flag = isValidBST(root);
        if (!flag) {
            return false;
        }
        if (root != null) {
            if (root.val <= val) {
                return false;
            }
            // 左子节点
            if (root.left != null) {
                flag = isValidBSTRight(root.left, val);
                if (!flag) {
                    return false;
                }
                if (root.val >= val && root.left.val >= root.val) {
                    flag = false;
                    System.out.println("boolean3==" + flag);
                    return false;
                }
            }
            //
            if (root.right != null) {
                flag = isValidBSTRight(root.right, val);
                if (!flag) {
                    return false;
                }
                if (root.val <= val && root.right.val <= root.val) {
                    flag = false;
                    System.out.println("boolean4==" + flag);
                    return false;
                }
            }
        }
        return flag;
    }


//    public boolean isValidBST(TreeNode root) {
//        return isValidBSTHelper(root, null, null);
//    }

    private boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        // 检查当前节点的值是否在范围内
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }

        // 递归检查左右子树
        return isValidBSTHelper(node.left, lower, val) && isValidBSTHelper(node.right, val, upper);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)))));
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
