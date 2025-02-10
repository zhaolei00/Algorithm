package com.zl.newhand;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/7 12:33
 * @Description : 二进制打印算法(13 = 00000000 00000000 00000000 00001101)
 */
public class Integer打印二进制 {

    public static String getIntegerBinary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getIntegerBinary(13));
        System.out.println(getIntegerBinary(5));
        System.out.println(getIntegerBinary(-5));
    }

}
