package com.zl.newhand.tiku;

/**
 * 位图:
 * 功能: 用一组bit来表示一个可确定的范围内的数(0~M)，是否存在。
 */
public class _6_位图 {

    private long[] bits;

    public _6_位图(int max) {
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        bits[num >> 6] |= (1L << (num & 63)); // 注意: 一定是 1L, 如果是1就有问题，因为是32位。
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

}
