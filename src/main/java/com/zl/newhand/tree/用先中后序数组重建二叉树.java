package com.zl.newhand.tree;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class 用先中后序数组重建二叉树 {

    //===============【题目】用先序数组和中序数组重建一棵树 条件:先序数组和中序数组没有重复值=====================
    public static TreeNode buildTree1(int[] xianArr, int[] zhongArr) {
        if (xianArr == null || zhongArr == null || xianArr.length != zhongArr.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < zhongArr.length; i++) {
            map.put(zhongArr[i], i);
        }
        return f(xianArr, 0, xianArr.length - 1, zhongArr, 0, zhongArr.length - 1, map);
    }

    // 在先序数组中 [L1,R1] 和中序数组中 [L2,R2] 构建二叉树。返回头节点。
    private static TreeNode f(int[] xianArr, int L1, int R1, int[] zhongArr, int L2, int R2, Map<Integer, Integer> map) {
        if (L1 > R1) {
            return null;
        }
        if (L1 == R1) { // 就一个节点，直接返回。
            return new TreeNode(xianArr[L1]);
        }
        TreeNode root = new TreeNode(xianArr[L1]);
        // 从中序中找到L1相等的数。每次都遍历复杂度比较高。用Map存储。
        int index = map.get(xianArr[L1]);
        // while (zhongArr[index] != xianArr[L1]) {
        //     index++;
        // }
        int leftNum = index - L2;
        TreeNode left = f(xianArr, L1 + 1, L1 + leftNum, zhongArr, L2, index - 1, map);
        TreeNode right = f(xianArr, L1 + leftNum + 1, R1, zhongArr, index + 1, R2, map);
        root.left = left;
        root.right = right;
        return root;
    }

}
