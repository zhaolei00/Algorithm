package org.example.newhand;

import java.util.Arrays;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 15:01
 * @Description :
 *      二分法相关算法
 *          什么情况下可以使用二分: 根据目标，如果二分之后，某一侧一定会有这个结果就可以二分。
 */
public class Binary {

    public static void main(String[] args) {
        System.out.println("测试开始");
        int maxLength = 1000;
        int maxValue = 100000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = RightComparator.getRandomArr3(maxLength, maxValue);
            if (!RightComparator.check(arr, Question4.getLocalMinimumIndex(arr))) {
                System.out.println("有问题");
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("Nice");
    }

    // 对数器
    private static class RightComparator {

        // 获取数组，升序且不重复
        private static int[] getRandomArr(int maxLength, int maxValue) {
            int length = (int) (Math.random() * maxLength) + 1;
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = (int) (Math.random() * maxValue);
            }
            // 去重
            arr = Arrays.stream(arr).distinct().toArray();
            Arrays.sort(arr);
            return arr;
        }

        // 获取数组，升序, 可能重复
        private static int[] getRandomArr2(int maxLength, int maxValue) {
            int length = (int) (Math.random() * maxLength) + 1;
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(arr);
            return arr;
        }

        private static int getIndex(int[] arr, int num) {
            int ans = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= num) {
                    ans = i;
                }
            }
            return ans;
        }

        // 获取数组，无序, 相邻位置不相等
        private static int[] getRandomArr3(int maxLength, int maxValue) {
            int length = (int) (Math.random() * maxLength) + 1;
            int[] arr = new int[length];
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < length; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i - 1] == arr[i]);
            }
            return arr;
        }

        private static boolean check(int[] arr, int index) {
            if (arr == null || arr.length < 2) {
                return index == -1;
            }
            int n = arr.length;
            if (arr[0] < arr[1]) {
                return index == 0;
            }
            if (arr[n - 2] > arr[n - 1]) {
                return index == n - 1;
            }
            return arr[index] < arr[index - 1]
                    && arr[index] < arr[index + 1];
        }
    }

    //===============【题目】给定arr数组(升序且不重复)，找到num的位置=====================
    private static class Question1 {
        public static int getIndex(int[] arr, int num) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException();
            }
            int left = 0;
            int right = arr.length - 1;
            // 左右指针还没找到，不存在此值，跳出.
            while (left <= right) {
                // 找到中间位置进行比较
                int mid = (left + right) >> 1;
                // 找到返回
                if (arr[mid] == num) {
                    return mid;
                }
                if (arr[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    //===============【题目】给定arr数组(升序，可能重复)，找到最左面>=num的位置=====================
    private static class Question2 {
        public static int getIndex(int[] arr, int num) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException();
            }
            int left = 0;
            int right = arr.length - 1;
            int res = -1;
            // 左右指针还没找到，不存在此值，跳出.
            while (left <= right) {
                // 找到中间位置进行比较
                int mid = (left + right) >> 1;
                if (arr[mid] >= num) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }

    //===============【题目】给定arr数组(升序，可能重复)，找到最右面<=num的位置=====================
    private static class Question3 {
        public static int getIndex(int[] arr, int num) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException();
            }
            int left = 0;
            int right = arr.length - 1;
            int res = -1;
            // 左右指针还没找到，不存在此值，跳出.
            while (left <= right) {
                // 找到中间位置进行比较
                int mid = (left + right) >> 1;
                if (arr[mid] <= num) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }

    //===============局部最小定义: [0] < [1] 0位置是局部最小 [n-2] > [n-1] n-1位置局部最小 [i-1]>[i]<[i+1] i位置局部最小=====================
    //===============【题目】给定arr数组(无序，相邻两个位置不等), 找到任意一个局部最小位置=====================

    private static class Question4 {
        private static int getLocalMinimumIndex(int[] arr) {
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
            int left = 1;
            int right = n - 2;

            while (left <= right) {
                int mid = (left + right) >> 1;
                if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                    return mid;
                }
                if (arr[mid - 1] < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            throw new IllegalArgumentException();
        }
    }
    //===============【题目】给定arr数组(无序，相邻两个位置不等), 找到所有局部最小位置=====================

}
