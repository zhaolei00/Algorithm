package com.zl.newhand.sort;

import java.util.Arrays;

/**
 * 归并排序定义: 让左右都有序，最近进行合并。
 */
public class _4_归并排序 {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 3, 1};
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

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
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
    }

}
