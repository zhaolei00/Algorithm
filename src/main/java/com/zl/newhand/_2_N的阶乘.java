package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 10:28
 * @Description : 给出一个N数(大于0)，计算 1! + 2! + 3! + N! 的结果
 */
public class _2_N的阶乘 {

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

    /**
     * 计算n的阶乘
     * 时间复杂度 : o(n)
     * 空间复杂度 : o(1)
     */
    public static int factorial_n(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    /**
     * 给定阶乘n， 计算ans = 1! + 2! + 3! ... + n!
     * 时间复杂度 : o(n)
     * 空间复杂度 : o(1)
     */
    public static int factorial_n_sum(int n) {
        int ans = 0;
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            ans += temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(factorial_n(5));
        System.out.println(factorial_n(4));
        System.out.println(factorial_n(3));
        System.out.println(factorial_n(2));
        System.out.println(factorial_n(1));
        System.out.println(factorial_n_sum(5));
    }

}
