package com.zl.newhand.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author zl
 * @Date 2025/2/13 11:50
 * @Description
 */
public class 合并K个有序链表 {

    //===============【题目】=====================
    //给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
    // 思路: 工具小根堆。 把所有链表的头部放入到小根堆中，取出小根堆的最小值Node，放入node的next放入到小根堆，再重复这个操作，直到小根堆为空。
    public static LinkedNode<Integer> mergeNLinked(LinkedNode<Integer>[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<LinkedNode<Integer>> mixHeap = new PriorityQueue<>(Comparator.comparingInt(LinkedNode::getV));
        for (LinkedNode<Integer> node : lists) {
            if (node == null) {
                continue;
            }
            mixHeap.add(node);
        }
        LinkedNode<Integer> ans = mixHeap.poll();
        LinkedNode<Integer> pre = ans;
        if (ans != null && ans.getNext() != null) {
            mixHeap.add(ans.getNext());
        }
        while (mixHeap.peek() != null) {
            LinkedNode<Integer> temp = mixHeap.poll();
            if (temp.getNext() != null) {
                mixHeap.add(temp.getNext());
            }
            pre.setNext(temp);
            pre = temp;
        }
        return ans;
    }

}
