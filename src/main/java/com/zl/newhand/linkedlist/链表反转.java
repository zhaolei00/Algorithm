package com.zl.newhand.linkedlist;

import com.zl.newhand.tiku._99_对数器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zl
 * @Date 2025/2/11 21:07
 * @Description
 */
public class 链表反转 {

    //===============【题目】给定单向链表Head, 进行反转=====================
    // head节点: 等待反转处理的节点。
    // pre节点: 等待反转处理的节点的前一个节点。因为单链表，在处理head反转时，需要知道，head反转后next需要指向谁。
    // next节点: 等待反转处理的下一个节点。因为单链表，在处理完head的反转后，找不到后面节点了，所以需要记录。这个是临时变量，可以把申请变量挪到while里，是一样的。
    public static LinkedNode singleLinkedReverse(LinkedNode head) {
        LinkedNode pre = null; // 头节点时，前面节点是null。
        LinkedNode next;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void testSingleLinkedReverse() {
        System.out.println("测试开始");
        int maxLength = 100;
        int maxValue = 1000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            LinkedNode oldHead = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            List<LinkedNode> oldLinkedNodeList = new ArrayList<>();
            LinkedNode oldHeadTemp = oldHead;
            while (oldHeadTemp != null) {
                oldLinkedNodeList.add(oldHeadTemp);
                oldHeadTemp = oldHeadTemp.getNext();
            }
            LinkedNode newHead = singleLinkedReverse(oldHead);
            if (!checkSingleLinkedReverse(oldLinkedNodeList, newHead)) {
                System.out.println("反转单链表有问题:");
                _99_对数器.printSingleLinked(newHead);
                break;
            }
        }
        System.out.println("Nice");
    }

    private static boolean checkSingleLinkedReverse(List<LinkedNode> oldLinkedNodeList, LinkedNode newHead) {
        List<LinkedNode> newLinkedNodeList = new ArrayList<>();
        while (newHead != null) {
            newLinkedNodeList.add(newHead);
            newHead = newHead.getNext();
        }
        Collections.reverse(newLinkedNodeList);
        return oldLinkedNodeList.equals(newLinkedNodeList);
    }

    //===============【题目】给定双向链表Head, 进行反转=====================
    public static LinkedNode doubleLinkedReverse(LinkedNode head) {
        LinkedNode pre = null;
        LinkedNode next;
        while (head != null) {
            next = head.getNext();
            head.setPre(next);
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void testDoubleLinkedReverse() {
        System.out.println("测试开始");
        int maxLength = 10;
        int maxValue = 100;
        int times = 10;
        for (int i = 0; i < times; i++) {
            LinkedNode oldHead = _99_对数器.randomGenDoubleLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(oldHead);
            LinkedNode newHead = doubleLinkedReverse(oldHead);
            _99_对数器.printSingleLinked(newHead);
        }
        System.out.println("Nice");
    }

    public static void main(String[] args) {
        // testSingleLinkedReverse();
        testDoubleLinkedReverse();
    }

}
