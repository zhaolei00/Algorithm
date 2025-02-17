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

}
