package com.zl.sort;

import com.zl.heap.MySmallHeap;

import java.util.Arrays;

/**
 */
public class _6_2_堆排序之K问题 {

    /**
     *【题目】给定一个无序数组arr，每个数在排好序后，最多移动K个距离。
     * 时间复杂度: o(N*logK)
     * 额外空间复杂度: o(K)
     */
    public static void heapSort(int[] arr, int K) {
        if (arr == null || arr.length < 2) {
            return;
        }
        MySmallHeap smallHeap = new MySmallHeap(K + 1);
        for (int i = 0; i <= K && i < arr.length; i++) {
            smallHeap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = smallHeap.poll();
            if (i + K + 1 < arr.length) {
                smallHeap.add(arr[i + K + 1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {12, 11, 9, 33, 55, 44};
        int k = 3;
        heapSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

}
