package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 *
 */
public class _2_冒泡排序 {

    /**
     * 0 ~ N-1 中 0 1、1 2、2 3、。。。N-2 N-1不断进行比较，如果大于，就交换。
     * 0 ~ N-1 中 0 1、1 2、2 3、。。。N-3 N-2不断进行比较，如果大于，就交换。
     * 就像鱼冒泡泡一样，最大值不断往最右侧送。
     * 时间复杂度: o(N^2)
     * 额外空间负责度: o(1) 只有N、i、j、j-1属于额外变量
     */
    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap2(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }














    /**
     * 最大值就像水里的泡泡一样，一点一点的往上浮。
     * 从右到左依次确定。
     * 时间复杂度: o(n^2)
     * 空间复杂度: o(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        // 0 ～ i 冒泡
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
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
        bubbleSort(arr);
        bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
