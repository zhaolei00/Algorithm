package org.example.hand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 12:06
 * @Description : 排序算法
 */
public class Sort {

    /**
     * 选择排序
     * 思路:
     * 0 ~ N-1 位置的最小值和 0 位置交换
     * 1 ~ N-1 位置的最小值和 1 位置交换
     * ... 以此类推
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        // 考虑边界值
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1 位置找出最小值和0交换
        // 1 ~ N-1 位置找出最小值和1交换
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mixValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                mixValueIndex = arr[mixValueIndex] > arr[j] ? j : mixValueIndex;
            }
            swap(arr, i, mixValueIndex);
        }
    }

    /**
     * 冒泡排序
     * 思路:
     * 0 1    1 2    2 3     3 4    n-2 n-1    一对一对对比，如果左面大于右面，进行交换。N的位置确定
     * 0 1    1 2    2 3     3 4    n-3 n-2    一对一对对比，如果左面大于右面，进行交换。N-1的位置确定
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        // 考虑边界
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            // 0 ~ i 进行冒泡
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
        bubbleSort(arr);
        printArr(arr);
    }

}
