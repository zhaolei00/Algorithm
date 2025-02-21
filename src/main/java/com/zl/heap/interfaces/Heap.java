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

    boolean contains(V v);

    /**
     * v元素改了，调整堆
     */
    void resign(V v);

    /**
     * 删除v元素
     */
    void remove(V v);

}
