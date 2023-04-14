package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/14 09:25
 * @Description :
 */
public class XOR {

    //====【题目】给定arr数组, 不用额外变量，交换i位置和j位置的数=====================
    // i和j位置相同会出错。
    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    //====【题目】给定arr数组, 有一种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的数=====================
    // 要求: 时间复杂度o(N), 额外空间复杂度o(1)
    private static int findOddNumberTimesNumber(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        return ans;
    }

    //====【题目】给定一个int值a，提取出最右侧的1 =====================
    // -a = ~a + 1
    private static int question1(int a) {
        return a & -a;
    }

    //====【题目】给定arr数组, 有两种数出现了奇数次，其他数都出现偶数次，找到这个出现奇数次的两种数=====================
    // 要求: 时间复杂度o(N), 额外空间复杂度o(1)
    private static int[] question2(int[] arr) {
        int eor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            eor1 ^= arr[i];
        }
        int lastBit = eor1 & -eor1;
        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((lastBit & arr[i]) == 0) {
                eor2 ^= arr[i];
            }
        }
        return new int[]{eor1 ^ eor2, eor2};
    }

    //====【题目】给定arr数组, 有一种数出现K次，其他数都出现M次，M>1, K<M, 找到出现K次的数=====================
    // 要求: 时间复杂度o(N), 额外空间复杂度o(1)
    // 步骤一: 初始化一个长度为32的int类型数组help
    // 步骤二: 把arr数组中的数的位信息出现的次数，保存到help的对应位置
    // 步骤三: 遍历help数组，如果位置上的数是M的整数倍，则出现K次的数在该位置不为1
    private static int question3(int[] arr, int K, int M) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int j = 0; j < help.length; j++) {
                help[j] += num >> j & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % M != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, -3, 4, 5, -2, 1, -3, 4, 5, 1, -3, 4, 5, 1, -3, 4, 5, 1, -3, 4, 5};
        System.out.println(question3(arr, 2, 5));
    }

}
