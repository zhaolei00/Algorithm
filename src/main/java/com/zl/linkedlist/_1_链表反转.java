package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 */
public class _1_链表反转 {

    /**
     * 反转单链表
     * head节点: 等待反转处理的节点。
     * pre节点: 等待反转处理的节点的前一个节点。因为单链表，在处理head反转时，需要知道，head反转后next需要指向谁。
     * next节点: 等待反转处理的下一个节点。因为单链表，在处理完head的反转后，找不到后面节点了，所以需要记录。这个是临时变量，可以把申请变量挪到while里，是一样的。
     */
    public static ListNode question1(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private static void testSingleLinkedReverse() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 1000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            ListNode oldHead = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            List<ListNode> oldListNodeList = new ArrayList<>();
            ListNode oldHeadTemp = oldHead;
            while (oldHeadTemp != null) {
                oldListNodeList.add(oldHeadTemp);
                oldHeadTemp = oldHeadTemp.next;
            }
            ListNode newHead = question1(oldHead);
            if (!checkSingleLinkedReverse(oldListNodeList, newHead)) {
                System.out.println("反转单链表有问题:");
                _99_对数器.printSingleLinked(newHead);
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkSingleLinkedReverse(List<ListNode> oldListNodeList, ListNode newHead) {
        List<ListNode> newListNodeList = new ArrayList<>();
        while (newHead != null) {
            newListNodeList.add(newHead);
            newHead = newHead.next;
        }
        Collections.reverse(newListNodeList);
        return oldListNodeList.equals(newListNodeList);
    }

    /**
     * 反转双链表
     */
    public static ListNode question2(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            head.pre = temp;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private static void testDoubleLinkedReverse() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 1000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            ListNode oldHead = _99_对数器.randomGenDoubleLinkedList(maxLength, maxValue);
            ListNode temp = oldHead;
            List<Integer> oldList = new ArrayList<>();
            while (temp != null) {
                oldList.add(temp.val);
                temp = temp.next;
            }
            ListNode newHead = question2(oldHead);
            if (!checkDoubleLinkedReverse(oldList, newHead)) {
                System.out.println("fail!");
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkDoubleLinkedReverse(List<Integer> oldList, ListNode newHead) {
        Collections.reverse(oldList);
        int index = 0;
        while (newHead != null) {
            if (newHead.val != oldList.get(index)) {
                return false;
            }
            newHead = newHead.next;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        testSingleLinkedReverse();
        testDoubleLinkedReverse();
    }

}
