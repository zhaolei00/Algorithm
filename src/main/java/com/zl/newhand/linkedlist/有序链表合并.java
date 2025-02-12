package com.zl.newhand.linkedlist;

import com.zl.newhand.tiku._99_对数器;

/**
 */
public class 有序链表合并 {

    // =============== 题目1: 有序链表合并 =====================
    // 给定两个有序链表的头节点 head1和head2
    // 返回合并之后的大链表，依然有序。
    // 思路: head1和head2进行比较，谁小返回谁。定义cur1和cur2和pre，cur1和cur2谁小pre.next连接谁

    public static Node<Integer> mergeLinked(Node<Integer> head1, Node<Integer> head2) {
        // 步骤1: 确定长短链表。
        // 步骤2: 因为是合并，长短链表谁先没都有可能。
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node<Integer> minHead = length(head1) > length(head2) ? head2 : head1;
        Node<Integer> maxHead = minHead == head1 ? head2 : head1;
        Node<Integer> ans = null;
        if (minHead.getV() <= maxHead.getV()) {
            ans = minHead;
            minHead = minHead.getNext();
        } else {
            ans = maxHead;
            maxHead = maxHead.getNext();
        }
        Node<Integer> cur; // 当前处理的节点。
        Node<Integer> last = ans; // 处理好的最后一个节点
        // 两个都不为空
        while (minHead != null && maxHead != null) {
            if (minHead.getV() <= maxHead.getV()) {
                cur = minHead;
                minHead = minHead.getNext();
            } else {
                cur = maxHead;
                maxHead = maxHead.getNext();
            }
            last.setNext(cur);
            last = cur;
        }
        if (minHead != null) {
            last.setNext(minHead);
        }
        if (maxHead != null) {
            last.setNext(maxHead);
        }
        return ans;
    }

    private static int length(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head != null) {
            size++;
            head = head.getNext();
        }
        return size;
    }

    private static void test() {
        int times = 2;
        int maxLength = 5;
        int maxValue = 20;
        for (int i = 0; i < times; i++) {
            Node head1 = _99_对数器.randomGenSortLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(head1);
            Node head2 = _99_对数器.randomGenSortLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(head2);
            Node ans = mergeLinked(head1, head2);
            _99_对数器.printSingleLinked(ans);
        }
    }

    public static void main(String[] args) {
        test();
    }

}
