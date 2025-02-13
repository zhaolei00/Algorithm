package com.zl.newhand.tree;

import java.util.HashMap;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/9 21:30
 * @Description :
 * 二叉树:
 * 先序遍历: 每一棵子树, 打印顺序为 头 左 右
 * 中序遍历: 每一棵子树, 打印顺序为 左 头 右
 * 后序遍历: 每一棵子树, 打印顺序为 左 右 头
 */
public class BinaryTree {

    private static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    // 递归序(很重要) 任何非空节点，都到达三次
    private static void f(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 1 什么信息都没有
        f(treeNode.left);
        // 2 能拿到左子树的所有信息 lInfo
        f(treeNode.right);
        // 3 能拿到右子树的所有信息 rInfo
    }

    //===============【题目】判断两颗树是否结构相同=====================
    private static boolean isSameTree(TreeNode head1, TreeNode head2) {
        if (head1 == null ^ head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) { // 为什么IDEA高亮? 此处只能是head1和head2都为空，或者都不为空。所以head2 == null是废话。
            return true;
        }
        return head1.val == head2.val && isSameTree(head1.left, head2.left) && isSameTree(head2.right, head2.right);
    }

    //===============【题目】判断一棵树是否是镜面树(对称树)=====================
    private static boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null ^ root.right == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode head1, TreeNode head2) {
        if (head1 == null ^ head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) { // 为什么IDEA高亮? 此处只能是head1和head2都为空，或者都不为空。所以head2 == null是废话。
            return true;
        }
        return head1.val == head2.val && isMirror(head1.left, head2.right) && isMirror(head1.right, head2.left);
    }

    //===============【题目】返回一棵树的最大深度=====================
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //===============【题目】用先序数组和中序数组重建一棵树 条件:先序数组和中序数组没有重复值=====================
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        // 记录位置，空间换时间。不然每次找先序数组中的节点在中序数组中的位置时，都需要遍历。
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return getRootNode(preorder,  0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    // 方法含义: 根据先序数组(l1,r1)和中序数组(l2,r2)重建一棵树
    // 思路: 先序树数组l1位置的数k一定是根节点，根据k找到中序数组的位置index, l2到index-1属于左子树的，index+1到r2属于右子树的，重复递归。
    //      最后生成root节点和连接上左右子树
    private static TreeNode getRootNode(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> valueIndexMap) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[l1]);
        if (l1 == r1) {
            return root;
        }
        int find = valueIndexMap.get(pre[l1]);
        // 个数 find - l2
        // 获取左树节点
        root.left = getRootNode(pre, l1 + 1, l1 + find - l2, in, l2, find - 1, valueIndexMap);
        // 获取右树节点
        root.right = getRootNode(pre, l1 + find - l2 + 1, r1, in, find + 1, r2, valueIndexMap);
        return root;
    }

    //===============【题目】二叉树按层遍历并收集节点=====================
    //https://leetcode.cn/problems/binary-tree-level-order-traversal/
    // 思路:
    // 先把root放入到队列中
    // 步骤一: 拿出此时队列的size, 执行size次步骤二
    // 步骤二: 弹出节点，先放左节点，再放右节点

    //===============【题目】二叉树按层遍历并收集节点 II=====================
    //https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/


    // 为什么LinkedList比Stack慢？

    //===============【题目】判断二叉树是否为平衡二叉树=====================
    // 平衡二叉树定义: 每一颗子树，左树高度 - 右树高度 <= 1，就是平衡树，有任何一棵违反，就不是平衡二叉树。
    // 思路:
    //      递归

    //===============【题目】二叉树是否为搜索二叉树=====================
    // 搜索二叉树定义: 每一颗子树，左树最大值 < 本节点值 < 右树最小值，有任何一棵违反，就不是搜索二叉树。
    // 思路:
    //      方法一: 中序遍历严格递增一定是搜索二叉树。
    //      方法二: 递归。

    //===============【题目】二叉树是否为平衡搜索二叉树=====================
    // 平衡搜索二叉树定义: 同时满足平衡二叉树和搜索二叉树

    // ===============【题目】能否组成路径和=====================
    // 给你二叉树的根节点root和一个表示目标和的整数targetSum。
    // 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。如果存在，返回true；否则，返回false。
    // 叶子节点是指没有子节点的节点。
    // 思路:
    //      方法一: 递归 设置全局变量isSum

    // ===============【题目】收集达标路径和=====================
    // 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    // 叶子节点 是指没有子节点的节点。
    // 思路:
    //      方法一: 递归

}
