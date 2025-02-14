package com.zl.newhand.tree;

/**
 */
public class 判断是否为平衡二叉树 {

    //===============【题目】判断二叉树是否为平衡二叉树=====================
    // 平衡二叉树定义: 左子树和右子树都是平衡二叉树，并且深度差不大于1。
    public static boolean isBalanceTree(TreeNode<Integer> root) {
        return getTreeNodeInfo(root).isBalance;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> a = new TreeNode<>(9);
        TreeNode<Integer> b = new TreeNode<>(20);
        TreeNode<Integer> c = new TreeNode<>(15);
        TreeNode<Integer> d = new TreeNode<>(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        System.out.println(isBalanceTree(root));
    }

    // 计算此树的Info信息
    private static Info getTreeNodeInfo(TreeNode<Integer> root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = getTreeNodeInfo(root.left);
        Info rightInfo = getTreeNodeInfo(root.right);
        return new Info(leftInfo.isBalance
                && rightInfo.isBalance
                && Math.abs(leftInfo.depth - rightInfo.depth) < 2, Math.max(leftInfo.depth, rightInfo.depth) + 1);
    }

    private static class Info {
        public boolean isBalance;
        public int depth;

        public Info(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

}
