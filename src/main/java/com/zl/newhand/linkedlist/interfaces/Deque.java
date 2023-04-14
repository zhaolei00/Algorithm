package com.zl.newhand.linkedlist.interfaces;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/9 00:53
 * @Description : 双向队列
 */
public interface Deque<V> {

    boolean isEmpty();

    int size();

    void firstOffer(V v);

    void lastOffer(V v);

    V firstPoll();

    V lastPoll();

}
