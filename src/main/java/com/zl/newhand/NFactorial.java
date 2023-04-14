package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 10:28
 * @Description : 给出一个N数(大于0)，计算 1! + 2! + 3! + N! 的结果
 */
public class NFactorial {

    /**
     * N的阶乘
     *
     * @param N
     * @return
     */
    private static int factorial(int N) {
        int res = 1;
        for (int i = 1; i <= N; i++) {
            res *= i;
        }
        return res;
    }

    /**
     * int ans = 1! + 2! + 3! + N!
     *
     * @param N
     * @return
     */
    private static int N_FACTORIAL(int N) {
        // 1! + 1!*2 + 2!*3
        int res = 0;
        int tmp = 1;
        for (int i = 1; i <= N; i++) {
            tmp = tmp * i;
            res += tmp;
        }
        return res;
    }

    //===============【题目】给定一个数组arr, 计算下标L到R位置上所有数的和。=====================
    // 思路: 前缀和数组，数组i位置是0到i位置所有数的和，所以计算下标L到R位置上所有数的和就是ans=[R]-[L-1],特殊情况，如果L为0，直接取[R]。
    // 前缀和数组就是一个辅助数组，帮助计算的。

    private static int[] help = null;

    // 计算L到R的和
    private static int arrLRSum(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0 || L > R || L >= arr.length || R >= arr.length) {
            return 0;
        }
        if (L == 0) {
            return help[R];
        }
        return help[R] - help[L - 1];
    }

    // 生成辅助数组
    private static void genHelpArr(int[] arr) {
        if (arr == null) {
            return;
        }
        help = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            help[i] += help[i - 1];
        }
    }

}
