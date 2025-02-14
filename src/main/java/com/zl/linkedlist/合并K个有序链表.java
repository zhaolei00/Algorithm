package com.zl.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 */
public class 合并K个有序链表 {

    //===============【题目】=====================
    //给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
    // 思路: 工具小根堆。 把所有链表的头部放入到小根堆中，取出小根堆的最小值Node，放入node的next放入到小根堆，再重复这个操作，直到小根堆为空。
    public static ListNode mergeNLinked(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> mixHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            mixHeap.add(node);
        }
        if (mixHeap.isEmpty()) {
            return null;
        }
        ListNode ans = mixHeap.poll();
        ListNode pre = ans;
        if (ans.next != null) {
            mixHeap.add(ans.next);
        }
        while (mixHeap.peek() != null) {
            ListNode temp = mixHeap.poll();
            if (temp.next != null) {
                mixHeap.add(temp.next);
            }
            pre.next = temp;
            pre = temp;
        }
        return ans;
    }

}
