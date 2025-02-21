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

    default boolean contains(V v) {
        throw new UnsupportedOperationException();
    };

    /**
     * v元素改了，调整堆
     */
    default void resign(V v) {
        throw new UnsupportedOperationException();
    };

    /**
     * 删除v元素
     */
    default void remove(V v) {
        throw new UnsupportedOperationException();
    };

}
