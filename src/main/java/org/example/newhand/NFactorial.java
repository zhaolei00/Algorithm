package org.example.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 10:28
 * @Description : 给出一个N数(大于0)，计算 1! + 2! + 3! + N! 的结果
 */
public class NFactorial {

    private static int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    private static int N_FACTORIAL(int n) {
        // 1! + 1!*2 + 2!*3
        int res = 0;
        int tmp = 1;
        for (int i = 1; i <= n; i++) {
            tmp = tmp * i;
            res += tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        // 1 + 2 + 6 + 24
        System.out.println(N_FACTORIAL(4));
    }

    //===============【题目】给定一个数组arr, 计算下标L到R位置上所有数的和。=====================
    // 思路: 前缀和数组，数组i位置是0到i位置所有数的和，所以计算下标L到R位置上所有数的和就是ans=[R]-[L-1],特殊情况，如果L为0，直接取[R]。
    // 前缀和数组就是一个辅助数组，帮助计算的。

}
