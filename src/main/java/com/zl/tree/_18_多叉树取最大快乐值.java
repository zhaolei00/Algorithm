package com.zl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class _18_多叉树取最大快乐值 {

    public static class PTreeNode {
        public int happy;

        public List<PTreeNode> nextList = new ArrayList<>();

        public PTreeNode(int happy) {
            this.happy = happy;
        }
    }

    /**
     * 【题目】给一个多叉树代表公司结构，给员工发邀请函，发完后，快乐值最大。每个节点有快乐值。相邻节点只能有一个来，另一个不能来。
     */
    public static int question(PTreeNode root) {
        Info info = process(root);
        return Math.max(info.haveMyMaxHappy, info.notMyMaxHappy);
    }

    private static Info process(PTreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        int haveMyMaxHappy = x.happy;
        int notMyMaxHappy = 0;
        for (PTreeNode next : x.nextList) {
            Info info = process(next);
            haveMyMaxHappy += info.notMyMaxHappy;
            notMyMaxHappy += Math.max(info.haveMyMaxHappy, info.notMyMaxHappy);
        }
        return new Info(haveMyMaxHappy, notMyMaxHappy);
    }

    public static class Info {
        public int haveMyMaxHappy;
        public int notMyMaxHappy;

        public Info(int haveMyMaxHappy, int notMyMaxHappy) {
            this.haveMyMaxHappy = haveMyMaxHappy;
            this.notMyMaxHappy = notMyMaxHappy;
        }
    }

}
