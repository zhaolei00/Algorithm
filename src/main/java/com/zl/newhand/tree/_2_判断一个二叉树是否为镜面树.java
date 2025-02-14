package com.zl.newhand.tree;

/**
 */
public class _2_判断一个二叉树是否为镜面树 {

    //===============【题目】判断一棵树是否是镜面树(对称树)=====================
    public static boolean isMirrorTree(TreeNode root) {
        return isMirror(root, root);

    }

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null ^ root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

}
