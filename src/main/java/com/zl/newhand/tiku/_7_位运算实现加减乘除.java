package com.zl.newhand.tiku;

/**
 */
public class _7_位运算实现加减乘除 {

    // 注意: 单纯位运算是比加减乘除要快，但是用位运算实现加减乘除要比原生Java的加减乘除要慢。
    // 但是位运算，一定比Java语言的加减乘除要快。 为什么呢? 下面实现的思路，就是计算机的实现思路。因为底层实现复杂度会相对高，所以位运算快。

    // 加法
    // 思路: a+b = a` + b` = a`` + b `` = 无进位相加 + 进位信息 不断计算，当进位信息为0时，无进位相加的结果就是相加的结果。
    //      异或是无进位相加    进位信息是 (a&b)<<1
    public static int add(int a, int b) {
        int sum;
        while (b != 0) {
            sum = a ^ b; // 无进位信息
            b = (a & b) << 1; // 进位信息
            a = sum;
        }
        return a;
    }

    // 减法 a - b = a + (-b) = a + (~b + 1)
    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    // 乘法
    // 思路: 和正常乘法运算一样，每位乘的结果相加。
    public static int multi(int a, int b) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int temp = b & (1 << i); // 这一位是0还是非0
            if (temp != 0) {
                ans = add(ans, a << i);
            }
        }
        return ans;
    }

    // 除法
    // 思路: 需要考虑系统最小值。被除数缩小多少倍 大于 除数，1再扩大多少倍，就是一部分商。可以用10进位类比，原理是一样的。
    private static int div(int a, int b) {
        // 处理系统最小值，因为系统最小值绝对值还是系统最小
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (b == Integer.MIN_VALUE) {
            return 0;
        }
        if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            int c = doDiv(add(a, 1), b);
            return c + doDiv(minus(a, multi(c, b)), b);
        }
        return doDiv(a, b);
    }

    private static int doDiv(int a, int b) {
        int a1 = a < 0 ? ~a + 1 : a;
        int b1 = b < 0 ? ~b + 1 : b;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            int temp = a1 >> i;
            if (temp >= b1) {
                ans |= 1 << i;
                a1 = minus(a1, b1 << i);
            }
        }
        return a < 0 != b < 0 ? ~ans + 1: ans;
    }

    public static void main(String[] args) {
        System.out.println(div(7, -3));
    }

}
