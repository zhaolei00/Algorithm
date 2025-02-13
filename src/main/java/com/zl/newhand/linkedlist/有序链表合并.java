package com.zl.newhand.linkedlist;

import com.zl.newhand.tiku._99_对数器;

/**
 */
public class 有序链表合并 {

    // =============== 题目1: 有序链表合并 =====================
    // 给定两个有序链表的头节点 head1和head2
    // 返回合并之后的大链表，依然有序。
    // 思路: head1和head2进行比较，谁小返回谁。定义cur1和cur2和pre，cur1和cur2谁小pre.next连接谁

    public static LinkedNode<Integer> mergeLinked(LinkedNode<Integer> head1, LinkedNode<Integer> head2) {
        // 步骤1: 确定长短链表。
        // 步骤2: 因为是合并，长短链表谁先没都有可能。
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        LinkedNode<Integer> ans = head1.getV() <= head2.getV() ? head1 : head2;
        // 小头
        LinkedNode<Integer> minHead = ans.getNext();
        // 大头
        LinkedNode<Integer> maxHead = ans == head1 ? head2 : head1;
        LinkedNode<Integer> last = ans; // 处理好的最后一个节点
        // 两个都不为空
        while (minHead != null && maxHead != null) {
            if (minHead.getV() <= maxHead.getV()) {
                last.setNext(minHead);
                minHead = minHead.getNext();
            } else {
                last.setNext(maxHead);
                maxHead = maxHead.getNext();
            }
            last = last.getNext();
        }
        last.setNext(minHead != null ? minHead : maxHead);
        return ans;
    }

    private static void test() {
        int times = 2;
        int maxLength = 5;
        int maxValue = 20;
        for (int i = 0; i < times; i++) {
            LinkedNode head1 = _99_对数器.randomGenSortLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(head1);
            LinkedNode head2 = _99_对数器.randomGenSortLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(head2);
            LinkedNode ans = mergeLinked(head1, head2);
            _99_对数器.printSingleLinked(ans);
        }
    }

    public static void main(String[] args) {
        test();
    }

}
