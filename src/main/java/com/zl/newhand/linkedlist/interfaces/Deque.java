package com.zl.newhand.linkedlist.interfaces;

/**
 * 双端队列
 */
public interface Deque<V> {

    boolean isEmpty();

    int size();

    void firstOffer(V v);

    void lastOffer(V v);

    V firstPoll();

    V lastPoll();

}
