package com.zl;

/**
 */
public class 编程小技巧 {

    /**
     * i 和 j 不能相等
     */
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 计算中间值
     */
    public static int getMid(int l, int r) {
        return l + ((r - l) >> 1);
    }

    /**
     * 获取最右侧的1
     */
    public static int getRightOne(int a) {
        // return a & (~a + 1);
        return a & -a;
    }

    /**
     * 取余
     * 思路: 做除法, 剩下的数就是余数。
     */
    private static int quYu(int a, int b) {
        int a1 = a < 0 ? ~a + 1 : a;
        int b1 = b < 0 ? ~b + 1 : b;
        for (int i = 30; i >= 0; i--) {
            int temp = a1 >> i;
            if (temp >= b1) {
                a1 -= b1 << i;
            }
        }
        return a < 0 ^ b < 0 ? -a1 : a1;
    }

}
