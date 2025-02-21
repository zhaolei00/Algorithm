package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 * 堆排序只能用大根堆，小根堆在排序过程中，前面小的确定完，如果不移动，没办法表示成完全二叉树。
 */
public class _6_1_堆排序 {

    /**
     * 时间复杂度: o(N*logN)
     * 额外空间复杂度:
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从上往下建堆，时间复杂度o(N*logN)
        // 从下往上建堆，时间复杂度o(N)
        for (int i = 1; i < arr.length; i++) {
            // 上浮
            shangFu(arr, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 最大数和最后面的交换，相当于取出0位置的数
            xiaChen(arr, 0, i);
        }
    }

    private static void shangFu(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void xiaChen(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int maxChild = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] >= arr[maxChild]) {
                break;
            }
            swap(arr, index, maxChild);
            index = maxChild;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int times= 100000;
        int maxValues = 1000;
        int maxLength = 1000;
        for (int i = 0; i < times; i++) {
            int[] arr = _99_对数器.randomGenIntArray(maxLength, maxValues);
            int[] arr1 = _99_对数器.copyArray(arr);
            int[] arr2 = _99_对数器.copyArray(arr);
            if (arr == null) {
                continue;
            }
            heapSort(arr1);
            Arrays.sort(arr2);
            if (!_99_对数器.arrayEquals(arr1, arr2)) {
                System.out.println("fail:" + Arrays.toString(arr));
                System.out.println("fail:" + Arrays.toString(arr1));
                System.out.println("fail:" + Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("Nice");
    }

}
