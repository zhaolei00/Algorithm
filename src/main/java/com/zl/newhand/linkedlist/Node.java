package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * 节点
 */
@Data
public class Node<V> {

    // 值
    private V v;

    // 前继节点
    private Node<V> pre;

    // 后继节点
    private Node<V> next;

    public Node() {
    }

    public Node(V v) {
        this.v = v;
    }

    public Node(V v, Node<V> next) {
        this.v = v;
        this.next = next;
    }
}
