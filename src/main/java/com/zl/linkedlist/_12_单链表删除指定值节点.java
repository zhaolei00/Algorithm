package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

/**
 */
public class _12_单链表删除指定值节点 {

    //===============【题目】给定单向链表Head, 删除所有值为t的节点，返回头节点=====================
    public static ListNode delTNode(ListNode root, int t) {
        if (root == null) {
            return null;
        }
        ListNode pre = null;
        ListNode ans = null;
        while (root != null) {
            // 说明前面有非t值的节点
            if (root.val == t) {
                if (pre != null) {
                    pre.next = root.next;
                }
            } else {
                pre = root;
                if (ans == null) {
                    ans = root;
                }
            }
            root = root.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode ans = delTNode(head, 5);
        _99_对数器.printSingleLinked(ans);
    }

}
