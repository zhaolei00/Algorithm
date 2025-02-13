package com.zl.newhand.tree;

/**
 */
public class 树的遍历 {

    // 先序遍历 先父
    public static void xian(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        xian(head.left);
        xian(head.right);
    }
    // 中序遍历 中父
    public static void zhong(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        zhong(head.left);
        System.out.println(head.value);
        zhong(head.right);
    }
    // 后序遍历 后父
    public static void hou(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        hou(head.left);
        hou(head.right);
        System.out.println(head.value);
    }

}
