package com.zl.newhand.tree;

/**
 */
public class 判断两个二叉树相同 {

    // ===============【题目】判断两颗树是否结构相同=====================
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val
                && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

}
