package com.zl.newhand.tiku;

/**
 */
public class _3_数组范围累加和 {

    // ========= 方案一: 生成一个二维数组 (横坐标,纵坐标) 代表 (start,end) 范围的累加和。 =====================

    private static int[][] pre1 = null;

    /**
     * 数组范围累加和
     */
    public static int arr_range_sum1(int start, int end) {
        return pre1[start][end];
    }

    private static void preHandler1(int[] arr) {
        pre1 = new int[arr.length][arr.length];
        int n = arr.length;
        // 进行预处理
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    pre1[i][j] = arr[j];
                } else {
                    pre1[i][j] = pre1[i][j - 1] + arr[j];
                }
            }
        }
    }

    // ========= 方案二: 生成一个前缀和数组 ================================================================

    private static int[] help = null;

    private static void preHandler2(int[] arr) {
        help = new int[arr.length];
        help[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            help[i] = help[i - 1] + arr[i];
        }
    }

    public static int arr_range_sum2(int[] arr, int start, int end) {
        return start == 0 ? help[end] : help[end] - help[start - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 1, 4, 6, 2, 9, 3, 7};
        preHandler1(arr);
        preHandler2(arr);
        System.out.println(arr_range_sum1(0, 0));
        System.out.println(arr_range_sum1(arr.length - 1, arr.length - 1));
        System.out.println(arr_range_sum1(0, 5));

        System.out.println(arr_range_sum2(arr, 0, 0));
        System.out.println(arr_range_sum2(arr, arr.length - 1, arr.length - 1));
        System.out.println(arr_range_sum2(arr, 0, 5));
    }
}
