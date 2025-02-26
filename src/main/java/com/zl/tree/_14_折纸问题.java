package com.zl.tree;

/**
 */
public class _14_折纸问题 {

    /**
     * 【题目】将纸条对折N次后，打印纸条上所有的凹凸折痕。
     */
    public void question1(int N) {
        process(1, N, true);
        System.out.println();
    }

    // 对折第i次的折痕 flag true为凹 false为凸
    private void process(int i, int N, boolean flag) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.print(flag ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        new _14_折纸问题().question1(1);
        new _14_折纸问题().question1(2);
        new _14_折纸问题().question1(3);
        new _14_折纸问题().question1(4);
    }
}
