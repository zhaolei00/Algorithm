package com.zl.sort;

import com.zl.tiku._99_对数器;

import java.util.Arrays;

/**
 */
public class _8_基数排序 {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int[] copy = new int[arr.length];
        for (int i = 1; i <= getMaxBitCount(max); i++) {
            // 此时是第i位进桶出桶
            int[] help = new int[10];
            // 统计每位出现的次数
            for (int j : arr) {
                help[getDigit(j, i)]++;
            }
            // 前缀和
            for (int j = 1; j < help.length; j++) {
                help[j] = help[j - 1] + help[j];
            }
            // 根据前缀和，判断这个数该放哪
            for (int j = arr.length - 1; j >= 0; j--) {
                int bitNum = getDigit(arr[j], i);
                copy[help[bitNum] - 1] = arr[j];
                help[bitNum]--;
            }
            // copy到原数组
            for (int j = 0; j < copy.length; j++) {
                arr[j] = copy[j];
            }
        }
    }

    private static int getDigit(int num, int bitCount) {
        for (int i = 1; i < bitCount; i++) {
            num /= 10;
        }
        return num % 10;
    }

    private static int getMaxBitCount(int num) {
        int ans = 1;
        while (num / 10 != 0) {
            ans++;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int times = 1000000;
        int maxLength = 100;
        int maxValue = 100000;
        System.out.println("开始测试");
        for (int i = 0; i < times; i++) {
            int[] arr1 = _99_对数器.randomGenIntArray(maxLength, maxValue);
            if (arr1 == null) {
                continue;
            }
            int[] arr2 = _99_对数器.copyArray(arr1);
            int[] arr3 = _99_对数器.copyArray(arr1);
            radixSort(arr1);
            Arrays.sort(arr2);
            if (!_99_对数器.arrayEquals(arr1, arr2)) {
                System.out.println("有错了:" + Arrays.toString(arr3));
                System.out.println("有错了:" + Arrays.toString(arr1));
                System.out.println("有错了:" + Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("Nice");
    }

}
