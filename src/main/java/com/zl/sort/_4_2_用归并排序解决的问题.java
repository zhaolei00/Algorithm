package com.zl.sort;

import com.zl.tiku._99_对数器;

/**
 */
public class _4_2_用归并排序解决的问题 {

    /**
     *【题目】小和问题 给定一个arr数组，让每个位置左边比他小的数相加，所有位置算出来的和再相加，求这个和数
     * 时间复杂度: o(N*logN)
     */
    public static int question1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process1(arr, 0, arr.length - 1, new int[arr.length]);
    }

    // 求数组arr在[L,R]范围上的小和
    private static int process1(int[] arr, int L, int R, int[] help) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        int leftSmallNum = process1(arr, L, mid, help);
        int rightSmallNum = process1(arr, mid + 1, R, help);
        return leftSmallNum + rightSmallNum + merge1(arr, L, mid, R, help);
    }

    // 合并数组，并返回小和
    private static int merge1(int[] arr, int L, int M, int R, int[] help) {
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        int smallSum = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) { // arr[p1] == arr[p2] 时, 取p2。因为此时不知道右面有多少个比arr[p1]大
                smallSum += (R - p2 + 1) * arr[p1];
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < R - L + 1; i++) {
            arr[L + i] = help[i];
        }
        return smallSum;
    }

    /**
     *【题目2】逆序对问题 给定一个arr数组，每个位置右边比他小的数的个数相加，得出逆序对数量
     * 时间复杂度: o(N*logN)
     */
    public static int question2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process2(arr, 0, arr.length - 1, new int[arr.length]);
    }

    // 获取数组arr在[L,R]上的逆序对数量
    private static int process2(int[] arr, int L, int R, int[] help) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process2(arr, L, mid, help) + process2(arr, mid + 1, R, help) + merge2(arr, L, mid, R, help);
    }

    private static int merge2(int[] arr, int L, int M, int R, int[] help) {
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        int ans = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[index++] = arr[p1++];
            } else {
                ans += (M - p1 + 1);
                help[index++] = arr[p2++];
            }
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < R - L + 1; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    /**
     *【题目2】给定一个arr数组，每个位置右边乘2比他小的数的个数相加，得出这个数量
     * 时间复杂度: o(N*logN)
     */
    public static int question3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process3(arr, 0, arr.length - 1, new int[arr.length]);
    }

    // 获取数组arr在[L...R]范围上，符合右边乘2还比此数小的个数
    private static int process3(int[] arr, int L, int R, int[] help) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process3(arr, L, mid, help)
                + process3(arr, mid + 1, R, help)
                + merge(arr, L, mid, R, help);
    }

    private static int merge(int[] arr, int L, int M, int R, int[] help) {
        int rSmall = M + 1;
        int ans = 0;
        for (int i = L; i <= M; i++) {
            while (rSmall <= R && arr[i] > (arr[rSmall] << 1)) {
                rSmall++;
            }
            ans += rSmall - M - 1;
        }
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) { // 有等于，就是有稳定性
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < R - L + 1; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    /**
     *【题目2】给定一个arr数组，有多少个子数组的和，在范围[lower,upper]内
     * 时间复杂度: o(N*logN)
     */
}
