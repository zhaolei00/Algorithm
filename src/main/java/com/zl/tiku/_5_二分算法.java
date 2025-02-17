package com.zl.tiku;

import com.zl.sort._1_选择排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  二分法相关算法
 *      什么情况下可以使用二分: 根据目标，如果二分之后，某一侧一定会有这个结果就可以二分。
 */
public class _5_二分算法 {

    /**
     *【题目】给定arr数组(升序且不重复)，找到num的位置
     * 时间复杂度: o(logN)
     * 额外空间复杂度: o(1) 只有L、R、mid变量
     */
    public static int question1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
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
            _1_选择排序.selectSort(arr);
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

    /**
     *【题目】给定arr数组(升序，可能重复)，找到最左面>=num的位置
     * 时间复杂度: o(logN)
     * 额外空间复杂度: o(1) L、R 有限几个变量
     */
    public static int question2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= num) {
                R = mid - 1;
                ans = mid;
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
            _1_选择排序.selectSort(arr);
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

    /**
     *【题目】给定arr数组(升序，可能重复)，找到最右面<=num的位置
     * 时间复杂度: o(logN)
     * 额外空间复杂度: o(1)
     */
    public static int question3(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
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
            _1_选择排序.selectSort(arr);
            if (!checkQuestion3(arr, question3(arr, num), num)) {
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

    /**
     * 局部最小定义: 数组为null或者只有一个数的数组组，局部最小为-1。[0]<[1] 0位置是局部最小, [n-2]>[n-1] n-1位置局部最小, [i-1]>[i]<[i+1] i位置局部最小。
     */
    /**
     *【题目】给定arr数组(无序，相邻两个位置不等), 找到任意一个局部最小位置
     * 时间复杂度: o(logN)
     * 额外空间复杂度: o(1) 只有N、L、R有限几个变量
     */
    public static int question4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        int N = arr.length;
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 1;
        int R = N - 2;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    private static void testQuestion4() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 20000;
        int times = 10000000;
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

    //===============【题目】给定arr数组(无序，相邻两个位置不等), 找到所有局部最小位置=====================
    public static List<Integer> question5(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        if (arr[0] < arr[1]) {
            ans.add(arr[0]);
        }
        if (arr[n - 1] < arr[n - 2]) {
            ans.add(arr[n - 1]);
        }
        int L = 1;
        int R = n - 2;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans.add(mid);
            }
            if (arr[mid] > arr[mid - 1]) {

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // testQuestion1();
        // testQuestion2();
        // testQuestion3();
        testQuestion4();
    }

}
