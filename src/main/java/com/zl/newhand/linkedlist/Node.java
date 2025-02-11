package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * @Author zl
 * @Date 2025/2/11 21:09
 * @Description
 */
@Data
public class Node {

    // 值
    private int v;

    // 前继节点
    private Node pre;

    // 后继节点
    private Node next;

    public Node() {
    }

    public Node(int v, Node next) {
        this.v = v;
        this.next = next;
    }
}
