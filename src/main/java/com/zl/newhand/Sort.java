package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 12:06
 * @Description : 排序算法
 */
public class Sort {

    /**
     * 选择排序
     * 思路:
     * 找到 0 ~ N-1 位置的最小值和 0 位置交换
     * 找到 1 ~ N-1 位置的最小值和 1 位置交换
     * ... 以此类推
     * 时间复杂度: o(N^2)
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
     * 0 1    1 2    2 3     3 4    n-2 n-1    一对一对对比，如果左面大于右面，进行交换。N-1的位置确定
     * 0 1    1 2    2 3     3 4    n-3 n-2    一对一对对比，如果左面大于右面，进行交换。N-2的位置确定
     * ... 以此类推
     * 时间复杂度: o(N^2)
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

    /**
     * 插入排序
     * 思路:
     * 0 ~ 0 自然就有序，不用管
     * 0 ～ 1 有序
     * 0 ～ 2 有序
     * 0 ～ N -1 有序
     * ... 以此类推
     * 时间复杂度: o(N^2)
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    /**
     * 数组中i位置和j位置数据进行交换
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
