package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 *
 */
public class _1_选择排序 {

    /**
     * 从 0 ～N -1 找到最小值和0交换。
     * 从 1 ～ N-1 找到最小值和1交换。
     * 直到 N-1 ~ N-1 找到最小值和N-1交换
     * 时间复杂度: o(N^2)
     * 额外空间复杂度: o(1) 只有N、mixIdx、i、j属于额外变量。
     */
    public static void selectSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mixIdx;
        for (int i = 0; i < N; i++) {
            mixIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[mixIdx]) {
                    mixIdx = j;
                }
            }
            swap2(arr, i, mixIdx);
        }
    }

    // 这种 i 和 j 不能相等，相等就会有问题。因为 A^A=0
    private static void swap2(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int mixIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[mixIdx] > arr[j]) {
                    mixIdx = j;
                }
            }
            swap(arr, i, mixIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 1, 4, 6, 2, 9, 3, 0};
        int[] arr2 = _99_对数器.copyArray(arr);
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        selectSort2(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

}
