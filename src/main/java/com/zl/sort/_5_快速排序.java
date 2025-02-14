package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class _5_快速排序 {

    //===============【题目】快速排序 递归实现=====================
    // 在[L,R]中以, 以R为分界线，分为三个区间，小于区间、等于区间、大于区间
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        f(arr, 0, arr.length - 1);
    }

    private static void f(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] pari = partition(arr, L, R);
        // pari[0] 小于区的数
        // pari[1] 大于区的数
        f(arr, L, pari[0]); // 左面有序继续递归
        f(arr, pari[1], R); // 右面有序继续递归
    }

    private static int[] partition(int[] arr, int L, int R) {
        int index = L;
        int lessIndex = L - 1;
        int gtIndex = R;
        while (index < gtIndex) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessIndex, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --gtIndex);
            } else {
                index++;
            }
        }
        swap(arr, gtIndex++, R);
        return new int[]{lessIndex, gtIndex};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 用队列保存之前递归的所有小任务。
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Deque<Task> deque = new LinkedList<>();
        deque.addLast(new Task(0, arr.length - 1));
        while (!deque.isEmpty()) {
            Task task = deque.pollFirst();
            if (task.L >= task.R) {
                continue;
            }
            int[] partition = partition(arr, task.L, task.R);
            deque.addLast(new Task(task.L, partition[0]));
            deque.addLast(new Task(partition[1], task.R));
        }
    }

    private static class Task {
        public int L;
        public int R;

        public Task(int l, int r) {
            L = l;
            R = r;
        }
    }


    public static void main(String[] args) {
        System.out.println("测试开始");
        int times = 1000000;
        int maxLength = 200;
        int maxValue = 100;
        for (int i = 0; i < times; i++) {
            int[] arr1 = _99_对数器.randomGenIntArray(maxLength, maxValue);
            int[] arr2 = _99_对数器.copyArray(arr1);
            int[] arr3 = _99_对数器.copyArray(arr1);
            _1_选择排序.selectSort(arr1);
            quickSort2(arr2);
            if (!_99_对数器.arrayEquals(arr1, arr2)) {
                System.out.println("算法出错了: " + Arrays.toString(arr1));
                System.out.println("算法出错了: " + Arrays.toString(arr2));
                System.out.println("算法出错了: " + Arrays.toString(arr3));
                break;
            }
        }
        System.out.println("Nice");
    }


    //===============【题目】快速排序 非递归实现=====================

}
