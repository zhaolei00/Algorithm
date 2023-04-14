package com.zl.newhand.linkedlist.interfaces;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/9 00:34
 * @Description : 栈
 */
public interface Stack<V> {

    boolean isEmpty();

    int size();

    void push(V v);

    V poll();

    V peek();

}
