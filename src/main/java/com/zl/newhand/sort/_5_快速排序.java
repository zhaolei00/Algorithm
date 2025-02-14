package com.zl.newhand.sort;

import com.zl.newhand.tiku._99_对数器;

import java.util.Arrays;

/**
 */
public class _5_快速排序 {

    //===============【题目】快速排序 递归实现=====================
    // 在[L,R]中以, 以R为分界线，[L,T] 都小于等于R，[T, R]都大于R
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        f(arr, 0, arr.length - 1);
    }

    private static void f(int[] arr, int L, int R) {
        // 10 3 5 6 7 4
        if (L >= R) {
            return;
        }
        int mid = splitNum(arr, L, R); // 0~3 0
        f(arr, L, mid - 1); // 左面有序继续递归
        f(arr, mid + 1, R); // 右面有序继续递归
    }

    private static int splitNum(int[] arr, int L, int R) {
        int index = L; // 处理的值
        int lessEqualsIndex = L - 1; // 小于等于区
        while (index <= R) {
            if (arr[index] <= arr[R]) {
                swap(arr, ++lessEqualsIndex, index);
            }
            index++;
        }
        return lessEqualsIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println("测试开始");
        int times = 1000000;
        int maxLength = 200;
        int maxValue = 100;
        for (int i = 0; i < times; i++) {
            int[] arr1 = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int[] arr2 = _99_对数器.copyArray(arr1);
            int[] arr3 = _99_对数器.copyArray(arr1);
            _1_选择排序.selectSort(arr1);
            quickSort(arr2);
            if (!_99_对数器.arrayEquals(arr1, arr2)) {
                System.out.println("算法出错了: " + Arrays.toString(arr1));
                System.out.println("算法出错了: " + Arrays.toString(arr2));
                System.out.println("算法出错了: " + Arrays.toString(arr3));
                break;
            }
        }
        System.out.println("Nice");
    }


    //===============【题目】快速排序 非递归实现=====================

}
