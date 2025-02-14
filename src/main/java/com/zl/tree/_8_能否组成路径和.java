package com.zl.tree;

/**
 *
 */
public class _8_能否组成路径和 {

    // ===============【题目】能否组成路径和=====================
    // https://leetcode.cn/problems/path-sum/description/
    // 给你二叉树的根节点root和一个表示目标和的整数targetSum。
    // 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。如果存在，返回true；否则，返回false。
    // 叶子节点是指没有子节点的节点。
    // 思路: 递归

    public static boolean hasPathNum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return process(root, 0, targetSum);
    }

    // 此方法含义:
    //      pre: 到达这个节点时，之前的路径累加和。
    //      targetSum : 目标和
    private static boolean process(TreeNode root, int pre, int targetSum) {
        if (root.left == null && root.right == null) {
            if (pre + root.val == targetSum) {
                return true;
            }
            return false;
        }
        boolean leftHas = false;
        if (root.left != null) {
            leftHas = process(root.left, pre + root.val, targetSum);
        }

        boolean rightHas = false;
        if (root.right != null) {
            rightHas = process(root.right, pre + root.val, targetSum);
        }
        return leftHas || rightHas;
    }

}
