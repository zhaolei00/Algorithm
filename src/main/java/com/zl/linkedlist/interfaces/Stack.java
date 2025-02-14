package com.zl.linkedlist.interfaces;

/**
 * 栈
 */
public interface Stack<V> {

    boolean isEmpty();

    int size();

    void push(V v);

    V poll();

    V peek();

}
