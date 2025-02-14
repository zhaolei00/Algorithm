package com.zl.newhand.tree;

/**
 */
public class 二叉树最大深度 {

    // ===============【题目】返回一棵树的最大深度=====================
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
