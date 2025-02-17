package com.zl;

/**
 */
public class XOR {

    /**
     * 【题目】给定arr数组, 有一种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的数
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int question1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = 0;
        for (int v : arr) {
            ans ^= v;
        }
        return ans;
    }

    /**
     * 【题目】给定arr数组, 有两种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的两种数
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int[] question2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int eor1 = 0;
        for (int val : arr) {
            eor1 ^= val;
        }
        // 此时eor = a ^ b;
        int rightOneBit = eor1 & -eor1; // 找任意一位不为0的都可以。就是进行分组归类的作用。
        int eor2 = 0;
        // 进行归类，rightOneBit位为1的和rightOneBit为不为1的。
        for (int val : arr) {
            if ((val & rightOneBit) == 0) {
                eor2 ^= val;
            }
        }
        return new int[]{eor1 ^ eor2, eor2};
    }

    /**
     * 【题目】给定arr数组, 有一种数出现K次，其他数都出现M次，M>1, K<M, 找到出现K次的数
     * 其实K<M条件，也可以换成k不等于aM，a为1、2、3、4、5。。。
     * 要求: 时间复杂度o(N), 额外空间复杂度o(1)
     */
    public static int question3(int[] arr, int k, int m) {
        // 解题核心就是: 每个二进制位个数相加，区别这个出现K此的数。
        int[] help = new int[32];
        // 获取一个数，二进制为1都是哪几位。
        // 因为数据是有限制的。所以help中不为0的并且不能整除m的，这个位置就是M数为1。
        for (int val : arr) {
            for (int i = 0; i < help.length; i++) { // 因为是固定长度，所以时间复杂度为o(N)。
                help[i] += (val >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    /**
     * 【题目】给定arr数组, 有一种数出现K次，其他数都出现M次，M>1, K<M, 找到出现K次的数,如果这个数没有出现k次，返回-1。
     */
    public static int question44(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int val : arr) {
            for (int i = 0; i < help.length; i++) {
                help[i] += ((val >> i) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % m == 0) {
                continue;
            }
            if (help[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int val : arr) {
                if (ans == val) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return 0;
    }

}
