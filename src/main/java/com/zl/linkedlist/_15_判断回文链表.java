package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

import java.util.Stack;

/**
 */
public class _15_判断回文链表 {

    /**
     *【题目】给一个链表，判断这个链表是否为回文结构
     * 时间复杂度: o(N)
     * 额外空间复杂度: o(1)
     */
    public static boolean question1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode midNode = getMidNode(head);
        ListNode tailNode = reverseLinked(midNode);
        ListNode temp = tailNode;
        boolean ans = true;
        while (head != null && temp != null) {
            if (head.val != temp.val) {
                ans = false;
                break;
            }
            head = head.next;
            temp = temp.next;
        }
        // 恢复链表
        reverseLinked(tailNode);
        return ans;
    }

    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环
            if (slow == fast) {
                return null;
            }
        }
        return slow;
    }

    private static ListNode reverseLinked(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     *【题目】给一个链表，判断这个链表是否为回文结构
     * 时间复杂度: o(N)
     * 额外空间复杂度: 最大o(N)
     */
    public static boolean question2(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null) {
            ListNode pop = stack.pop();
            if (pop.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int times = 100000;
        int maxLength = 20;
        int maxValue = 10;
        for (int i = 0; i < times; i++) {
            ListNode listNode = _99_对数器.randomGenLinkedList(maxLength, maxValue);

            ListNode temp = _99_对数器.copyLinked(listNode);
            boolean b1 = question1(temp);
            boolean b2 = question2(temp);
            if (b1) {
                _99_对数器.printSingleLinked(listNode);
            }
            if (b1 != b2) {
                _99_对数器.printSingleLinked(listNode);
                _99_对数器.printSingleLinked(temp);
                System.out.println("Fail: " + b1 + "-" + b2);
                return;
            }
        }
        System.out.println("Nice");
    }

}
