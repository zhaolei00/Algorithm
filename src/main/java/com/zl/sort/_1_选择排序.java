package com.zl.sort;

import java.util.Arrays;

/**
 */
public class _1_选择排序 {

    /**
     * 思路:
     * 找到 0 ~ N-1 位置的最小值和 0 位置交换
     * 找到 1 ~ N-1 位置的最小值和 1 位置交换
     * ... 以此类推
     * 从左到右依次确定
     *
     * 时间复杂度: o(n^2)
     * 空间复杂度: o(1)
     */
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

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 1, 4, 6, 2, 9, 3, 0};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
