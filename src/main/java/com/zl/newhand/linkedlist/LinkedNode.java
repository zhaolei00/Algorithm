package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * 节点
 */
@Data
public class LinkedNode<V> {

    // 值
    private V v;

    // 前继节点
    private LinkedNode<V> pre;

    // 后继节点
    private LinkedNode<V> next;

    public LinkedNode() {
    }

    public LinkedNode(V v) {
        this.v = v;
    }

    public LinkedNode(V v, LinkedNode<V> next) {
        this.v = v;
        this.next = next;
    }
}
