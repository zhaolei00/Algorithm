package com.zl.tree;

/**
 * //===============【题目】二叉树是否为平衡搜索二叉树 就是平衡二叉树和搜索二叉树的结合 =====================
 */
public class _6_判断是否为二叉搜索树 {

    //===============【题目】二叉树是否为搜索二叉树=====================
    // 思路1: 中序遍历的结果是否有序。
    // 思路2: 递归
    public static boolean isSearchTree(TreeNode root) {
        return getInfo(root).isSearch;
    }

    private static Info getInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        int min = root.val;
        int max = root.val;
        boolean isSearch = true;
        Info leftInfo = getInfo(root.left);
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            isSearch = isSearch && leftInfo.isSearch && root.val > leftInfo.max;
        }
        Info rightInfo = getInfo(root.right);
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            isSearch = isSearch && rightInfo.isSearch && root.val < rightInfo.min;
        }
        return new Info(isSearch, min, max);
    }

    private static class Info {
        public boolean isSearch;
        public int min;
        public int max;

        public Info(boolean isSearch, int min, int max) {
            this.isSearch = isSearch;
            this.min = min;
            this.max = max;
        }
    }

}
