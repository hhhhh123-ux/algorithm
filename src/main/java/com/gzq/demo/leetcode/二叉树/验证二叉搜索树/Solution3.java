package com.gzq.demo.leetcode.二叉树.验证二叉搜索树;

public class Solution3 {


    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        Boolean flag = true;
        int val = root.val;
        if (root != null) {
            // 左子节点
            if (root.left != null) {
                flag = isValidBSTLeft(root.left, val);
                if (root.left.val >= root.val || !flag) {
                    System.out.println("boolean5==" + flag);
                    return false;
                }
            }
            // 右子节点
            if (root.right != null) {
                flag = isValidBSTRight(root.right, val);
                if (root.right.val <= root.val || !flag) {
                    System.out.println("boolean6==" + flag);
                    return false;
                }
            }
        }
        return flag;
    }

    //    public boolean isValidBSTLeft(TreeNode root, int val) {
//
//        Boolean flag = true;
//        flag = isValidBST(root);
//        if (!flag) {
//            return false;
//        }
//        if (root != null) {
//            if (root.val >= val) {
//                return false;
//            }
//            // 左子节点
//            if (root.left != null) {
//                flag = isValidBSTLeft(root.left, val);
//                if (!flag) {
//                    return false;
//                }
//                if (root.val >= val && root.left.val >= root.val) {
//                    System.out.println(root.val);
//                    flag = false;
//                    System.out.println("boolean1==" + flag);
//                    return false;
//                }
//            }
//            //
//            if (root.right != null) {
//                flag = isValidBSTLeft(root.right, val);
//                if (!flag) {
//                    return false;
//                }
//                if (root.val <= val && root.right.val <= root.val) {
//                    flag = false;
//                    System.out.println("boolean2==" + flag);
//                    return false;
//                }
//            }
//        }
//        return flag;
//    }
    public boolean isValidBSTLeft(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val >= val) {
            return false;
        }

        // 左子节点
        if (!isValidBSTLeft(root.left, val) && isValidBST(root.left)) {
            return false;
        }

        // 右子节点
        if ((root.val >= val || !isValidBSTLeft(root.right, val)) && isValidBST(root.right) ) {
            return false;
        }

        return true;
    }

    //    public boolean isValidBSTRight(TreeNode root, int val) {
//        Boolean flag = true;
//        flag = isValidBST(root);
//        if (!flag) {
//            return false;
//        }
//        if (root != null) {
//            if (root.val <= val) {
//                return false;
//            }
//            // 左子节点
//            if (root.left != null) {
//                flag = isValidBSTRight(root.left, val);
//                if (!flag) {
//                    return false;
//                }
//                if (root.val >= val && root.left.val >= root.val) {
//                    flag = false;
//                    System.out.println("boolean3==" + flag);
//                    return false;
//                }
//            }
//            //
//            if (root.right != null) {
//                flag = isValidBSTRight(root.right, val);
//                if (!flag) {
//                    return false;
//                }
//                if (root.val <= val && root.right.val <= root.val) {
//                    flag = false;
//                    System.out.println("boolean4==" + flag);
//                    return false;
//                }
//            }
//        }
//        return flag;
//    }
    public boolean isValidBSTRight(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val <= val) {
            return false;
        }

        // 左子节点
        if (!isValidBSTRight(root.left, val) && isValidBST(root.left) ) {
            return false;
        }

        // 右子节点
        if ((root.val <= val || !isValidBSTRight(root.right, val)) && isValidBST(root.right)) {
            return false;
        }

        return true;
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
