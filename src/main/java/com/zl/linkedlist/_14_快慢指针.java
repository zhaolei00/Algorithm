package com.zl.linkedlist;

/**
 */
public class _14_快慢指针 {

    /**
     *【题目】给链表头节点, 奇数长度返回中点，偶数长度返回上中点。
     */
    public static ListNode question1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 循环链表
                return null;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        System.out.println(question1(root).val);
    }

    /**
     *【题目】给链表头节点, 奇数长度返回中点，偶数长度返回下中点。
     */
    public static ListNode question2(ListNode head) {
        return null;
    }

    /**
     *【题目】给链表头节点, 奇数长度返回中点前一个，偶数长度返回上中点前一个。
     */

    /**
     *【题目】给链表头节点, 奇数长度返回中点前一个，偶数长度返回下中点前一个。
     */

}
