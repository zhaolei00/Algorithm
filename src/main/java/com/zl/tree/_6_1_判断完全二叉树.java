package com.zl.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class _6_1_判断完全二叉树 {

    public static boolean question1(TreeNode root) {
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

    public static boolean question2(TreeNode root) {
        return process(root).isCBT;
    }

    private static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true,0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        boolean flag = false;
        if (leftInfo.height == rightInfo.height) {
            flag = (1 << leftInfo.height) - 1 == leftInfo.nodeSize;
        } else if (leftInfo.height == rightInfo.height + 1) {
            flag = (1 << rightInfo.height) - 1 == rightInfo.nodeSize;
        }
        return new Info(leftInfo.isCBT && rightInfo.isCBT && flag,
                leftInfo.nodeSize + rightInfo.nodeSize + 1,
                Math.max(leftInfo.height, rightInfo.height) + 1);
    }

    public static class Info {

        public boolean isCBT; // 是否是完全二叉树

        public int nodeSize;

        public int height;

        public Info(boolean isCBT, int nodeSize, int height) {
            this.isCBT = isCBT;
            this.nodeSize = nodeSize;
            this.height = height;
        }
    }

    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(10);
        head1.left = new TreeNode(16);
        head1.right = new TreeNode(81);
        System.out.println(question2(head1));
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (question1(head) != question2(head)) {
                System.out.println("Oops!");
                return;
            }
        }
        System.out.println("finish!");
    }

}
