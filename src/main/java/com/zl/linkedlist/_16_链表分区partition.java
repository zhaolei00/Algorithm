package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

/**
 */
public class _16_链表分区partition {

    /**
     *【题目】将给定链表，分为小于区、等于区、大于区，返回链表节点。
     */
    public static ListNode question1(ListNode head, int v) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode minHead = null;
        ListNode minTail = null;
        ListNode midHead = null;
        ListNode midTail = null;
        ListNode maxHead = null;
        ListNode maxTail = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < v) {
                if (minHead == null) {
                    minHead = head;
                    minTail = head;
                } else {
                    minTail.next = head;
                    minTail = head;
                }
            } else if (head.val == v) {
                if (midHead == null) {
                    midHead = head;
                    midTail = head;
                } else {
                    midTail.next = head;
                    midTail = head;
                }
            } else {
                if (maxHead == null) {
                    maxHead = head;
                    maxTail = head;
                } else {
                    maxTail.next = head;
                    maxTail = head;
                }
            }
            head = next;
        }

        if (minTail != null) {
            minTail.next = midHead;
            midTail = midTail != null ? midTail : minTail;
        }
        if (midTail != null) {
            midTail.next = maxHead;
        }
        return minHead != null ? minHead : midHead != null ? midHead : maxHead;
    }

    public static void main(String[] args) {
        // ListNode listNode = _99_对数器.randomGenLinkedList(10, 10);
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        _99_对数器.printSingleLinked(listNode);
        System.out.println("======");
        listNode = question1(listNode, 3);
        _99_对数器.printSingleLinked(listNode);
    }
}
