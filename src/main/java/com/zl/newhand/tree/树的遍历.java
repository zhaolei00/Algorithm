package com.zl.newhand.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

    // 层序遍历
    // 思路: 因为返回值是每次节点的list，所以需要两个双端队列，来不断变化。
    public static List<List<Integer>> ceng1(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode<Integer>> deque1 = new ArrayDeque<>();
        Deque<TreeNode<Integer>> deque2 = new ArrayDeque<>();
        deque1.addLast(root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        while (!deque1.isEmpty()) {
            TreeNode<Integer> node = deque1.pollFirst();
            if (node.left != null) {
                deque2.addLast(node.left);
            }
            if (node.right != null) {
                deque2.addLast(node.right);
            }
            mid.add(node.value);
            if (deque1.isEmpty()) {
                Deque<TreeNode<Integer>> temp = deque1;
                deque1 = deque2;
                deque2 = temp;
                ans.add(mid);
                mid = new ArrayList<>();
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
