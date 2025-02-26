package com.zl.tree;

/**
 */
public class _16_找到最大子树是搜索二叉树 {

    /**
     * 【题目】找到子树是搜索二叉树，并且节点数量最多。
     */
    public int question(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxNum;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        boolean isBST = true;
        int nodeNum = 1;
        int min = root.val;
        int max = root.val;
        int maxNum = 0;
        if (leftInfo != null) {
            nodeNum += leftInfo.nodeNum;
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            isBST = leftInfo.nodeNum == leftInfo.maxNum && root.val > leftInfo.max;
            maxNum = Math.max(maxNum, leftInfo.maxNum);
        }
        if (rightInfo != null) {
            nodeNum += rightInfo.nodeNum;
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            isBST = isBST && rightInfo.nodeNum == leftInfo.maxNum && root.val < rightInfo.min;
            maxNum = Math.max(maxNum, rightInfo.maxNum);
        }
        if (isBST) {
            maxNum = nodeNum;
        }

        return new Info(nodeNum, maxNum, min, max);
    }

    public static class Info {
        public int nodeNum;
        public int maxNum;

        public int min;

        public int max;

        public Info(int nodeNum, int maxNum, int min, int max) {
            this.nodeNum = nodeNum;
            this.maxNum = maxNum;
            this.min = min;
            this.max = max;
        }
    }

}
