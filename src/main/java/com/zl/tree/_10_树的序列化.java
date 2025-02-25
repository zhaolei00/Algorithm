package com.zl.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class _10_树的序列化 {

    public Queue<Integer> preSerial(TreeNode root) {
        Queue<Integer> ans = new LinkedList<>();
        preSerial(root, ans);
        return ans;
    }

    private void preSerial(TreeNode root, Queue<Integer> ans) {
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(root.val);
        preSerial(root.left, ans);
        preSerial(root.right, ans);
    }

    public TreeNode buildPre(Queue<Integer> serial) {
        if (serial == null || serial.isEmpty()) {
            return null;
        }
        Integer poll = serial.poll();
        if (poll == null) {
            return null;
        }
        TreeNode ans = new TreeNode(poll);
        ans.left = buildPre(serial);
        ans.right = buildPre(serial);
        return ans;
    }

    public Queue<Integer> levelSerial(TreeNode root) {
        Queue<Integer> ans = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> temp = new LinkedList<>();
            temp.add(root);
            ans.add(root.val);
            while (!temp.isEmpty()) {
                root = temp.poll();
                if (root.left != null) {
                    temp.add(root.left);
                    ans.add(root.left.val);
                } else {
                    ans.add(null);
                }
                if (root.right != null) {
                    temp.add(root.right);
                    ans.add(root.right.val);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public TreeNode buildLevel(Queue<Integer> serial) {
        if (serial == null || serial.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(serial.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer left = serial.poll();
            if (left != null) {
                TreeNode treeNode = new TreeNode(left);
                poll.left = treeNode;
                queue.add(treeNode);
            }
            Integer right = serial.poll();
            if (right != null) {
                TreeNode treeNode = new TreeNode(right);
                poll.right = treeNode;
                queue.add(treeNode);
            }
        }
        return root;
    }

}
