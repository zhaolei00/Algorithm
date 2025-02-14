package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * 链表节点
 */
@Data
public class ListNode<V> {

    // 值
    private V v;

    // 前继节点
    private ListNode<V> pre;

    // 后继节点
    private ListNode<V> next;

    public ListNode() {
    }

    public ListNode(V v) {
        this.v = v;
    }

    public ListNode(V v, ListNode<V> next) {
        this.v = v;
        this.next = next;
    }
}
