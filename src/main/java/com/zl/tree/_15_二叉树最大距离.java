package com.zl.tree;

/**
 */
public class _15_二叉树最大距离 {

    /**
     * 【题目】最大距离定义: 一个节点到另一个节点的所有节点数量
     */
    public int question(TreeNode root) {
        return process(root).maxDistance;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rigintInfo = process(root.right);
        return new Info(Math.max(Math.max(leftInfo.maxDistance, rigintInfo.maxDistance),
                leftInfo.height + rigintInfo.height + 1),
                Math.max(leftInfo.height, rigintInfo.height) + 1);
    }

    public static class Info {
        public int maxDistance;

        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

}
