package com.zl.newhand.tree;

import java.util.*;

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

    // 层序遍历 并各自收集每层节点
    // 思路: 因为返回值是每次节点的list，所以需要两个双端队列，来不断变化。
    public static List<List<Integer>> ceng1(TreeNode<Integer> root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode<Integer>> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> mid = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> treeNode = deque.pollFirst();
                mid.add(treeNode.value);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
                ans.add(mid);
            }
        }
        return ans;
    }

    //===============【题目】二叉树按层遍历并收集节点 II=====================
    //https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
    public static List<List<Integer>> ceng2(TreeNode<Integer> root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode<Integer>> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> mid = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> treeNode = deque.pollFirst();
                mid.add(treeNode.value);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
                ans.add(0, mid);
            }
        }
        return ans;
    }

    // 递归序(很重要，任何非空节点，都到达三次)
    // 这个需要好好理解，后续算法题的变种，都是靠这个原理进行解决的。
    public static void f(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // 1. 什么信息都没有。只能有根节点的值。
        f(root.left);
        // 2. 能得到左子树的所有信息。
        f(root.right);
        // 3. 能得到右子树的所有信息
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> a = new TreeNode<>(8);
        TreeNode<Integer> b = new TreeNode<>(1);
        root.left = a;
        root.right = b;
        TreeNode<Integer> c = new TreeNode<>(3);
        TreeNode<Integer> d = new TreeNode<>(5);
        a.left = c;
        a.right = d;
        TreeNode<Integer> e = new TreeNode<>(7);
        TreeNode<Integer> f = new TreeNode<>(2);
        b.left = e;
        b.right = f;
        List<List<Integer>> lists = ceng1(root);
        System.out.println(lists);
    }
}
