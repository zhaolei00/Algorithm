package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 12:33
 * @Description : 二进制打印算法(13 = 00000000 00000000 00000000 00001101)
 */
public class BinaryPrint {

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
