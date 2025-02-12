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

    public static int div(int a, int b) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(multi(1000, -11));
    }

    //===============【题目】位运算实现加减乘除 =====================
    // 注意: 单纯位运算是比加减乘除要快，但是用位运算实现加减乘除要比原生Java的加减乘除要慢。
    // 异或是无进位相加    进位信息是 (a&b)<<1
    // 加法实现思路: a+b = a` + b` = a`` + b `` = 无进位相加 + 进位信息 不断计算，当进位信息为0时，无进位相加的结果就是相加的结果。
    // 减法时间思路: a-b = a+(-b) = add(a,add(~b,1))。 原理是 -N=~N+1
    // 乘法实现思路: a*b = a右面补 每个b的非0位位置个0后相加。
    // 除法实现思路: 输入a,b取绝对值,a,b都为非负数,a/b=c, 最终结果c=c'+c''+c'''+... ,c'都是2^n。
    //             也就是说，a不断从大到小右移，找到大于等于b就是得到c'，但是这个c'是需要扩大移动的位数的，a减去b的c'，剩下的数继续算是否有大于等于b的。
    //             考虑 a,b为系统最小
    //             a,b 都为系统最小 等于1
    //             a 为系统最小, b 不为系统最小。
    //                          如果b为-1,结果为系统最大+1，但是没法表示，硬性规定结果为系统最大。
    //                          如果b非-1，a/b 过程 (a+1)/b=c, a-b*c=d, d/b=e, 结果就为c+e。
    //             a 不为系统最小, b 为系统最小 等于0
    //             a,b 都不为系统最小 正常算

}
