package com.zl.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class _12_树最大宽度 {

    public int question1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(max, size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll);
                }
                if (poll.right != null) {
                    queue.add(poll);
                }
            }
        }
        return max;
    }

}
