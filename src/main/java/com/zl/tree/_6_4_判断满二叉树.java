package com.zl.tree;

/**
 */
public class _6_4_判断满二叉树 {

    public static void main(String[] args) {
        System.out.println(new _6_4_判断满二叉树().question(null));
    }

    public boolean question(TreeNode root) {
        Info info = process(root);
        return (1 << info.height) - 1 == info.nodeNum;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        return new Info(leftInfo.nodeNum + rightInfo.nodeNum + 1,
                Math.max(leftInfo.height, rightInfo.height) + 1);
    }

    public static class Info {
        public int nodeNum;

        public int height;

        public Info(int nodeNum, int height) {
            this.nodeNum = nodeNum;
            this.height = height;
        }
    }

}
