package org.example.hand;

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

}
