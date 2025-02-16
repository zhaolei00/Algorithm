package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 */
public class _3_插入排序 {

    /**
     * 0 ~ 0 有序
     * 0 ～ 1 有序
     * 0 ～ N-1 有序
     * 时间复杂度: o(N^2)
     * 额外空间复杂度: o(1) 只有N、i、j 额外变量
     */
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap2(arr, j, j - 1);
            }
        }
    }

    private static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }



























    /**
     * 思路: (前缀依次有序)
     *      0 ~ 1 有序
     *      0 ~ 2 有序
     *      0 ~ n - 1 有序
     *      tips: 因为是前缀有序, 当不小于前面的数, 就终止。
     * 时间复杂度: o(n^2)
     * 空间复杂度: o(1)
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ n - 1 有序
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 1, 4, 6, 2, 9, 3, 0};
        int[] arr2 = _99_对数器.copyArray(arr);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        insertSort2(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

}
