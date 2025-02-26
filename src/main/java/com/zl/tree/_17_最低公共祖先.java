package com.zl.tree;

/**
 *
 */
public class _17_最低公共祖先 {

    public TreeNode question1(TreeNode root, TreeNode A, TreeNode B) {
        return process(root, A, B).minParent;
    }

    private Info process(TreeNode x, TreeNode A, TreeNode B) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x, A, B);
        Info rightInfo = process(x, A, B);
        if (leftInfo.minParent != null || rightInfo.minParent != null) {
            return new Info(true, true, leftInfo.minParent == null ? rightInfo.minParent : leftInfo.minParent);
        }
        boolean hasA = leftInfo.hasA || rightInfo.hasA || x == A;
        boolean hasB = leftInfo.hasB || rightInfo.hasB || x == B;
        return new Info(hasA, hasB, hasA && hasB ? x : null);
    }

    public static class Info {
        public boolean hasA;
        public boolean hasB;
        public TreeNode minParent;

        public Info(boolean hasA, boolean hasB, TreeNode minParent) {
            this.hasA = hasA;
            this.hasB = hasB;
            this.minParent = minParent;
        }
    }

}
