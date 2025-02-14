package com.zl.tiku;

/**
 * 位图:
 * 功能: 用一组bit来表示一个可确定的范围内的数(0~M)，是否存在。
 * 如果是 -M ~ N 用 (0～N+M)范围来表示，在0～M-1映射成(-M~-1)。
 */
public class _6_位图 {

    private long[] bits;

    public _6_位图(int max) {
        bits = new long[(max >> 6) + 1];
    }

    // -M ~ N 。整体偏移M个位置
    public _6_位图(int mix, int max) {
        this((~mix + 1) + max);
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
