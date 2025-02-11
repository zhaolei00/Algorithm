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
    public static Node singleLinkedReverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    private static boolean check(List<Node> oldNodeList, Node newHead) {
        List<Node> newNodeList = new ArrayList<>();
        while (newHead != null) {
            newNodeList.add(newHead);
            newHead = newHead.getNext();
        }
        Collections.reverse(newNodeList);
        return oldNodeList.equals(newNodeList);
    }

    public static void main(String[] args) {
        int maxLength = 100;
        int maxValue = 1000;
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            Node oldHead = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            List<Node> oldNodeList = new ArrayList<>();
            Node oldHeadTemp = oldHead;
            while (oldHeadTemp != null) {
                oldNodeList.add(oldHeadTemp);
                oldHeadTemp = oldHeadTemp.getNext();
            }
            Node newHead = singleLinkedReverse(oldHead);
            if (!check(oldNodeList, newHead)) {
                System.out.println("反转单链表有问题:");
                _99_对数器.printLinkedList(newHead);
                break;
            }
        }
    }

}
