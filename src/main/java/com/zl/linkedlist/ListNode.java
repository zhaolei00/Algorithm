package com.zl.linkedlist;

/**
 * 链表节点
 */
public class ListNode {

    // 值
    public int val;

    // 前继节点
    public ListNode pre;

    // 后继节点
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
