package com.zl.newhand;

import com.zl.newhand.sort._2_选择排序;

import java.util.Arrays;

/**
 *  二分法相关算法
 *      什么情况下可以使用二分: 根据目标，如果二分之后，某一侧一定会有这个结果就可以二分。
 */
public class _5_二分算法 {

    //===============【题目】给定arr数组(升序且不重复)，找到num的位置=====================
    public static int question1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int L = 0;
        int R = n - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    private static void testQuestion1() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 20000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int num = _4_随机数概率问题.equalProbability5(maxValue);
            _2_选择排序.selectSort(arr);
            if (!checkQuestion1(arr, question1(arr, num), num)) {
                System.out.println("fail 算法有问题: num:" + num + ", " + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkQuestion1(int[] arr, int targetIndex, int num) {
        if (arr == null || arr.length == 0) {
            return targetIndex == -1;
        }
        if (targetIndex == -1) {
            return !existNum(arr, num);
        }
        return arr[targetIndex] == num;
    }

    private static boolean existNum(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    //===============【题目】给定arr数组(升序，可能重复)，找到最左面>=num的位置=====================
    public static int question2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    private static void testQuestion2() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 20000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int num = _4_随机数概率问题.equalProbability5(maxValue);
            _2_选择排序.selectSort(arr);
            if (!checkQuestion2(arr, question2(arr, num), num)) {
                System.out.println("fail 算法有问题: num:" + num + ", " + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkQuestion2(int[] arr, int targetIndex, int num) {
        if (arr == null || arr.length == 0) {
            return targetIndex == -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i == targetIndex;
            }
        }
        return targetIndex == -1;
    }

    //===============【题目】给定arr数组(升序，可能重复)，找到最右面<=num的位置=====================
    public static int question3(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    private static void testQuestion3() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 20000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int num = _4_随机数概率问题.equalProbability5(maxValue);
            _2_选择排序.selectSort(arr);
            if (!checkQuestion2(arr, question2(arr, num), num)) {
                System.out.println("fail 算法有问题: num:" + num + ", " + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkQuestion3(int arr[], int targetIndex, int num) {
        if (arr == null || arr.length == 0) {
            return targetIndex == -1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i == targetIndex;
            }
        }
        return targetIndex == -1;
    }

    //====局部最小定义: 数组为null或者只有一个数组，局部最小为-1。
    //                [0]<[1] 0位置是局部最小, [n-2]>[n-1] n-1位置局部最小, [i-1]>[i]<[i+1] i位置局部最小===

    //===============【题目】给定arr数组(无序，相邻两个位置不等), 找到任意一个局部最小位置=====================
    public static int question4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int n = arr.length;
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 2] > arr[n - 1]) {
            return n - 1;
        }
        // 方式1: 因为上面已经判断了0和n-1位置是否局部最小, 0~n-1会存在超边界问题。例如W例子(54545),所以条件为L < R - 1。
        // int L = 0;
        // int R = n - 1;
        // while (L < R - 1) {
        //     int mid = (L + R) / 2;
        //     if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
        //         return mid;
        //     }
        //     if (arr[mid] < arr[mid - 1]) {
        //         L = mid + 1;
        //     } else {
        //         R = mid - 1;
        //     }
        // }
        // return arr[L] < arr[R] ? L : R;

        // 方式2: 因为上面已经判断了0和n-1位置是否局部最小,所以范围可以缩小到1~n-2
        int L = 1;
        int R = n - 2;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;
            }
            if (arr[mid] < arr[mid - 1]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    private static void testQuestion4() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 20000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = _99_对数器.randomGenNotEqualArray(maxLength, maxValue);
            if (!checkQuestion4(arr, question4(arr))) {
                System.out.println("fail 算法有问题:" + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkQuestion4(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return target == -1;
        }
        if (arr[0] < arr[1]) {
            return target == 0;
        }
        int n = arr.length;
        if (arr[n - 1] < arr[n - 2]) {
            return target == n - 1;
        }
        return arr[target] < arr[target - 1] && arr[target] < arr[target + 1];
    }

    public static void main(String[] args) {
        testQuestion1();
        testQuestion2();
        testQuestion3();
        testQuestion4();
    }

    //===============【题目】给定arr数组(无序，相邻两个位置不等), 找到所有局部最小位置=====================

}
