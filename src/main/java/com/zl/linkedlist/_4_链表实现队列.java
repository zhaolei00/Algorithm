package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Deque;
import com.zl.linkedlist.interfaces.Queue;

/**
 *
 */
public class _4_链表实现队列 {

    // =========== 单链表实现队列 ===========
    // 功能: 增、取、看
    public static class MyQueue implements Queue<Integer> {
        private ListNode head;
        private ListNode tail;
        private int size;

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void offer(Integer val) {
            ListNode cur = new ListNode(val);
            if (head == null) {
                head = tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        @Override
        public Integer poll() {
            if (head == null) {
                return null;
            }
            Integer ans = head.val;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return ans;
        }

        @Override
        public Integer peek() {
            Integer ans = null;
            if (head != null) {
                ans = head.val;
            }
            return ans;
        }
    }

    // =========== 双链表实现双端队列 ===========
    // 功能: 头增、头取、头看、尾增、尾取、尾看
    // tips: 单链表为什么不能实现双端队列?
    //       因为头增、头取、尾增用单链表都能实现，但是尾取实现不了。因为取完尾后，tail找不到上一个节点。只能从前面遍历。那么复杂度就不是o(1),而是o(n)了。
    public static class MyDeque implements Deque<Integer> {
        private ListNode head;
        private ListNode tail;
        private int size;

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void firstOffer(Integer val) {
            ListNode cur = new ListNode(val);
            if (head == null) {
                head = tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
            size++;
        }

        @Override
        public void lastOffer(Integer val) {
            ListNode cur = new ListNode(val);
            if (head == null) {
                head = tail = cur;
            } else {
                cur.pre = tail;
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        @Override
        public Integer firstPoll() {
            if (head == null) {
                return null;
            }
            Integer ans = head.val;
            size--;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return ans;
        }

        @Override
        public Integer lastPoll() {
            if (head == null) {
                return null;
            }
            Integer ans = tail.val;
            size--;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            return ans;
        }

    }

}
