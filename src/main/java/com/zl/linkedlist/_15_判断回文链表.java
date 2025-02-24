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
                // return null;
            }
        }
        return slow;
    }

    private static ListNode reverseLinked(ListNode head) {
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

    private static void testQuestion1() {
        System.out.println("测试开始");
        int times = 100000;
        int maxLength = 20;
        int maxValue = 10;
        for (int i = 0; i < times; i++) {
            ListNode listNode = _99_对数器.randomGenLinkedList(maxLength, maxValue);

            ListNode temp = _99_对数器.copyLinked(listNode);
            boolean b1 = question1(temp);
            boolean b2 = question2(temp);
            if (b1 != b2) {
                _99_对数器.printSingleLinked(listNode);
                _99_对数器.printSingleLinked(temp);
                System.out.println("Fail: " + b1 + "-" + b2);
                return;
            }
        }
        System.out.println("Nice");
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

    /**
     *【题目】给定链表头节点，L1->L2->L3->L4->R1->R2->R3->R4, 返回链表L1->R4->L2->R3->L3->R2->L4->R1
     */
    public static ListNode question3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode ans = head;
        ListNode midNode = getMidNode(head);
        ListNode tail = reverseLinked(midNode);

        // 处理第一个节点
        ListNode headNext;
        headNext = head.next;
        head.next = tail;
        head = headNext;
        ListNode tailPre = tail;
        tail = tail.next;
        while (head != null && tail != null) {
            // 奇数时
            if (head == tail) {
                head.next = null;
                break;
            }
            // 偶数时
            if (head == tail.next) {
                tailPre.next = head;
                head.next = tail;
                tail.next = null;
                break;
            }
            // 中间
            headNext = head.next;
            tailPre.next = head;
            head.next = tail;
            head = headNext;
            tailPre = tail;
            tail = tail.next;
        }
        return ans;
    }

    private static void testQuestion3() {
        System.out.println("测试开始");
        int times = 1;
        int maxLength = 5;
        int maxValue = 10;
        for (int i = 0; i < times; i++) {
            ListNode listNode = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(listNode);
            ListNode listNode1 = question3(listNode);
            _99_对数器.printSingleLinked(listNode1);
        }
        System.out.println("Nice");
    }

    public static void main(String[] args) {
        // testQuestion1();
        testQuestion3();
    }

}
