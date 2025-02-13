package com.zl.newhand.tree;

import java.util.ArrayDeque;
import java.util.Deque;

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

    // 层序遍历 依次放入到双端队列，从前取，从后放。
    public static void ceng(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode<Integer>> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode<Integer> treeNode = deque.getFirst();
            System.out.println(treeNode.value);
            if (treeNode.left != null) {
                deque.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.addLast(treeNode.right);
            }
        }
    }
}
