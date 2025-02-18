package com.zl.tiku;

/**
 */
public class _8_异或算法 {

    /**
     * 【题目】给定arr数组, 有一种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的数
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int question1(int[] arr) {
        int ans = 0;
        for (int val : arr) {
            ans ^= val;
        }
        return ans;
    }

    /**
     * 【题目】给定arr数组, 有两种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的两种数
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int[] question2(int[] arr) {
        int eor = 0;
        for (int val : arr) {
            eor ^= val;
        }
        int rightOneBit = eor & -eor;
        int eor2 = 0;
        for (int val : arr) {
            if ((val & rightOneBit) == 0) {
                eor2 ^= val;
            }
        }
        return new int[] {eor ^ eor2, eor2};
    }

    /**
     * 【题目】给定arr数组, 有一种数出现K次，其他数都出现M次，M>1, K<M, 找到出现K次的数
     * 其实K<M条件，也可以换成k不等于aM，a为1、2、3、4、5。。。
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int question3(int[] arr, int k, int m) {
        int[] help = new int[32]; // 统计没位上出现的次数
        for (int val : arr) {
            for (int i = 0; i < help.length; i++) {
                help[i] += (val >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 【题目】给定arr数组, 有一种数出现K次，其他数都出现M次，M>1, K<M, 找到出现K次的数,如果这个数没有出现k次，返回-1。
     */
    public static int question4(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int val : arr) {
            for (int i = 0; i < help.length; i++) {
                help[i] += (val >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % m == 0) {
                continue;
            }
            if (help[i] % m == k) {
                ans |= 1 << i;
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int val : arr) {
                if (val == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }

}
