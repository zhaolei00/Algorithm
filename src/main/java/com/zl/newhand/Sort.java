package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 12:06
 * @Description : 排序算法
 */
public class Sort {

    /**
     * 打印数组
     */
    private static void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 4, 2, 3, 5, 8, 7, 9};
        printArr(arr);
        mergeSort2(arr);
        printArr(arr);
    }

    //===============【题目】归并排序 递归实现=====================
    // 思路: 数组arr, 让数组L到R有序，拆解成L到mid和mid+1到R有序，再进行L到mid和mid+1到R merge。
    // 时间复杂度: o(N*logN)
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) >> 1;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    //===============【题目】归并排序非递归实现=====================
    // 思路: 步长 1 2 4 8 依次翻倍，让左组和右组进行merge，最后有序。局部有序，再整体有序。
    private static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;
        while (step < N) {
            int L = 0;
            while (L < N) {
                if (step >= N - L) {
                    break;
                }
                int mid = L + step - 1;
                int R = Math.min(mid + step, N - 1);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            if (step > N/2) {
                break;
            }
            step <<= 1;
        }
    }

    //===============【题目】快速排序 递归和非递归实现=====================

}
