package com.zl.newhand.tree;

/**
 */
public class 判断一个二叉树是否为镜面树 {

    //===============【题目】判断一棵树是否是镜面树(对称树)=====================
    public static boolean isMirrorTree(TreeNode<Integer> root) {
        return isMirror(root, root);

    }

    private static boolean isMirror(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null ^ root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.value.equals(root2.value) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

}
