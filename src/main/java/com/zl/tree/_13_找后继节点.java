package com.zl.tree;

/**
 *
 */
public class _13_找后继节点 {

    public static class PTreeNode {
        public int val;
        public PTreeNode left;
        public PTreeNode right;
        public PTreeNode parent;
    }

    /**
     * 【题目】给定二叉树中的一个节点X，找到X的后继节点。后继节点定义: 中序遍历的下一个节点
     */
    public PTreeNode question(PTreeNode root) {
        if (root == null) {
            return null;
        }
        // 第一种情况: x有右树，后继一定是右树的最左节点。
        if (root.right != null) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
        // 找到父亲的左孩子是此节点，返回。找不到为空。下面这个条件判断有两个含义。左父亲和右父亲都包含了。
        // 找到我是父亲的左节点，返回。
        PTreeNode parent = root.parent;
        while (parent != null && parent.right == root) {
            root = parent;
            parent = root.parent;
        }
        // // 我就是根节点且没有右树，肯定没有后继节点。
        // if (root.parent == null) {
        //     return null;
        // }
        // // 第二种情况: x无右树，且x是父亲的左孩子。
        // if (root.parent.left == root) {
        //     return root.parent;
        // }
        // // 第三种情况: x无右树，且x是父亲的右孩子，找到父亲是左孩子的节点，节点的父节点是后继。如果中途父节点为空，没有后继。
        // while (root.parent != null && root.parent.parent != null) {
        //     if (root.parent.parent.left == root.parent) {
        //         return root.parent.parent;
        //     }
        //     root = root.parent;
        // }
        return parent;
    }

}
