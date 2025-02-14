package com.zl.newhand.tree;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class 收集达标路径和 {

    // ===============【题目】收集达标路径和=====================
    // 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    // 叶子节点 是指没有子节点的节点。
    // 思路: 递归
    public static List<List<Integer>> path(TreeNode root, int targetNum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        process(root, 0, new ArrayList<>(), targetNum, ans);
        return ans;
    }

    private static void process(TreeNode root, int pre, List<Integer> prePath, int target, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (pre + root.val == target) {
                ArrayList<Integer> list = new ArrayList<>(prePath);
                list.add(root.val);
                ans.add(list);
            }
            return;
        }

        prePath.add(root.val);
        if (root.left != null) {
            process(root.left, pre + root.val, prePath, target, ans);
        }

        if (root.right != null) {
            process(root.right, pre + root.val, prePath, target, ans);
        }
        prePath.remove(prePath.size() - 1);
    }

}
