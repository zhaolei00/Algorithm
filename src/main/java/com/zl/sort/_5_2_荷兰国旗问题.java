package com.zl.sort;

import java.util.Arrays;

/**
 * @Author zl
 * @Date 2025/2/19 21:34
 * @Description
 */
public class _5_2_荷兰国旗问题 {

    /**
     *【题目一】给定一个arr数组和x值，小于等于x放左边，大于x放右边。
     * 时间复杂度: o(N)
     * 空间复杂度: o(1)
     */
    public static void question1(int[] arr, int x) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = 0;
        int max = arr.length;
        while (index < max) {
            if (arr[index] <= x) {
                index++;
            } else {
                swap(arr, index, --max);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 1, 2, 8, 9, 5};
        question1(arr, 7);
        System.out.println(Arrays.toString(arr));
    }

}
