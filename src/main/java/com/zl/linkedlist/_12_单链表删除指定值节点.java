package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

/**
 */
public class _12_单链表删除指定值节点 {

    //===============【题目】给定单向链表Head, 删除所有值为t的节点，返回头节点=====================

    /**
     *【题目】给定单向链表Head, 删除所有值为t的节点，返回头节点
     * 方式一
     */
    public static ListNode question1(ListNode head, int t) {
        ListNode ans = null;
        ListNode pre = null;
        while (head != null) {
            if (head.val == t) {
                if (pre != null) {
                    pre.next = head.next; // 删节点
                }
            } else {
                pre = head;
                if (ans == null) {
                    ans = pre;
                }
            }
            head = head.next;
        }
        return ans;
    }

    /**
     *【题目】给定单向链表Head, 删除所有值为t的节点，返回头节点
     * 方式二
     */
    public static ListNode question2(ListNode head, int t) {
        while (head != null) {
            if (head.val != t) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == t) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
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
        ListNode ans = question2(head, 5);
        _99_对数器.printSingleLinked(ans);
    }

}
