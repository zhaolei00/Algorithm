package com.zl.heap;

import java.util.Arrays;

/**
 */
public class _1_最大线段重合问题 {

    /**
     *【题目】线段用[L,R]数组表示，重合的线段大小>=1，求最多重合的线段数量
     * 时间复杂度:
     */
    public static int question(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        MySmallHeap smallHeap = new MySmallHeap(arr.length);
        // 1. 把线段以线段开始排序
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            while (!smallHeap.isEmpty() && left >= smallHeap.peek()) {
                smallHeap.poll();
            }
            smallHeap.add(right);
            ans = Math.max(ans, smallHeap.size());
        }
        return ans;
    }

    public static void heapSort(int[][] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            shangFu(arr, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            xiaChen(arr, 0, i);
        }
    }

    private static void shangFu(int[][] arr, int index) {
        while (arr[index][0] > arr[(index - 1) / 2][0]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void xiaChen(int[][] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int maxChild = left + 1 < size && arr[left + 1][0] > arr[left][0] ? left + 1 : left;
            if (arr[maxChild][0] > arr[index][0]) {
                swap(arr, maxChild, index);
                index = maxChild;
                left = index * 2 + 1;
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void systemSort(int[][] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
    }

}
