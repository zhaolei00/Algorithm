package com.zl.newhand.tiku;

import com.zl.newhand.tiku._4_随机数概率问题;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 14:42
 * @Description :
 *      对数器(正确的比较)
 *          作用:
 *              1. 生成随机样本。
 *              2. 肯定正确的解决流程，不考虑复杂度。
 *              3. 自己写的算法，是否正确，通过随机样本，比较2和3的结果。如果结果有差异，则算法有问题。
 *                 根据有问题的case，进行调试，找问题更快。
 */
public class _99_对数器 {

    // TODO 需要补充各种工具。例如: 生成随机长度和随机大小的数组。等等。
    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] randomGenIntArray(int maxLength, int maxValue) {
        if (_4_随机数概率问题.equalProbability1() <= 0.1) {
            return null;
        }
        int[] arr = new int[_4_随机数概率问题.equalProbability5(maxLength)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = _4_随机数概率问题.equalProbability5(maxValue);
        }
        return arr;
    }

    public static int[] randomGenNotEqualArray(int maxLength, int maxValue) {
        if (_4_随机数概率问题.equalProbability1() <= 0.1) {
            return null;
        }
        int[] arr = new int[_4_随机数概率问题.equalProbability5(maxLength)];
        if (arr.length > 0) {
            arr[0] = _4_随机数概率问题.equalProbability5(maxValue);
            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = _4_随机数概率问题.equalProbability5(maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

}
