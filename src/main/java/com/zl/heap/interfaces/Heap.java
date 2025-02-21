package com.zl.heap.interfaces;

/**
 * 堆能力接口
 */
public interface Heap<V> {

    boolean isEmpty();

    int size();

    void add(V v);

    V poll();

    V peek();

}
