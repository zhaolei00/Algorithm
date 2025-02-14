package com.zl.newhand.sort;

import com.zl.newhand.tiku._99_对数器;

import java.util.Arrays;

/**
 * 归并排序定义: 让左右都有序，最近进行合并。
 */
public class _4_归并排序 {

    //===============【题目】归并排序递归实现=====================
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        f(arr, 0, arr.length - 1);
    }

    // 干一件事，让 [L1,R1] [L2,R2] 有序，进行合并
    private static void f(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        f(arr, L, mid);
        f(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        // 左面都有序了，右面也有序了。进行合并(merge)。
        int[] help = new int[R - L + 1];
        int hi = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[hi++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[hi++] = arr[p1++];
        }

        while (p2 <= R) {
            help[hi++] = arr[p2++];
        }
        for (int k : help) {
            arr[L++] = k;
        }
    }

    //===============【题目】归并排序非递归实现=====================
    // 这里的step代表，从左到右，每次把step为一组的保证有序。
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1; // 这个步长代表，步长个为一组, 步长以mid为中点，左和右进行merge。
        do {
            step <<= 1;
            for (int i = 0; i < N; i += step) {
                int L = i;
                int R = L + step - 1;
                int mid = L + ((R - L) >> 1);
                // 代表右面没有了
                if (mid >= N - 1) {
                    continue;
                }
                // 右面可能比左面短，进行越界判断。
                merge(arr, L, mid, R >= N ? N - 1: R);
            }
        } while (step < N);
    }
    // 对比mergeSort2的不同实现。 这里的step代表的是左数组和有数组的大小。
    public static void mergeSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;
        while (step < N) {
            int L = 0;
            while (L < N) {
                // 刚刚好凑够左数组
                if (N - L <= step) {
                    break;
                }
                // 有右数组
                int mid = L + step - 1;
                int R = Math.min(mid + step, N - 1);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            if (step > (N >> 1)) {
                break;
            }
            step <<= 1;
        }
    }

    public static void main(String[] args) {
        int times = 100000;
        int maxLength = 1000;
        int maxValue = 1000;
        System.out.println("开始测试");
        for (int i = 0; i < times; i++) {
            int[] arr1 = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int[] arr2 = _99_对数器.copyArray(arr1);
            int[] arr3 = _99_对数器.copyArray(arr1);
            mergeSort1(arr1);
            mergeSort3(arr2);
            if (!_99_对数器.arrayEquals(arr1, arr2)) {
                System.out.println("有错了:" + Arrays.toString(arr3));
                System.out.println("有错了:" + Arrays.toString(arr1));
                System.out.println("有错了:" + Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("Nice");
    }


}
