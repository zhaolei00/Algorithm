package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * 反转链表相关算法
 */
public class ReverseLinkedList {

    //===============【题目】给定单向链表Head, 进行反转=====================
    private static class ReverseSingleLinkedList {
        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                // head 记录要反转的节点
                // pre 记录要反转的前一个节点
                // next 记录要反转的后一个节点
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    //===============【题目】给定双向链表Head, 进行反转=====================
    private static class ReverseDoubleLinkedList {
        public ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                // head 记录要反转的节点
                // pre 记录要反转的前一个节点
                // next 记录要反转的后一个节点
                next = head.next;
                head.next = pre;
                head.pre = next;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    //===============【题目】给定单向链表Head, 删除所有值为t的节点，返回头节点=====================
    private static ListNode deleteNodeByValue(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode target = head;
        while (target != null) {
            if (target.val == val) {
                if (pre == null) {
                    head = target.next;
                } else {
                    pre.next = target.next;
                }
            } else {
                pre = target;
            }
            target = target.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        deleteNodeByValue(head, 5);
    }

    @Data
    private static class ListNode {
        private int val;

        private ListNode pre;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
