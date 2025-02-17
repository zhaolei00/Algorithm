package com.zl;

/**
 * @Author zl
 * @Date 2025/2/17 17:06
 * @Description
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

}
