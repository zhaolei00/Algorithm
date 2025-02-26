package com.zl.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class _6_1_判断完全二叉树 {

    public boolean question(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 遍历每个节点，左右子节点不都在时，后续节点必须是叶子节点。有右无左，即不是。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if ((leaf && (poll.left != null || poll.right != null)) ||
                    (poll.left == null && poll.right != null)) {
                return false;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left == null || poll.right == null) {
                leaf = true;
            }
        }
        return true;
    }

}
