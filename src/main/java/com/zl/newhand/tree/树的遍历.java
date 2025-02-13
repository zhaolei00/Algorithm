package com.zl.newhand.tree;

/**
 */
public class 树的遍历 {

    // 先序遍历 先父
    public static void xian(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        xian(root.left);
        xian(root.right);
    }
    // 中序遍历 中父
    public static void zhong(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        zhong(root.left);
        System.out.println(root.value);
        zhong(root.right);
    }
    // 后序遍历 后父
    public static void hou(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        hou(root.left);
        hou(root.right);
        System.out.println(root.value);
    }

}
