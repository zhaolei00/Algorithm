package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Stack;

/**
 *
 */
public class 单链表实现栈 {

    // =========== 单链表实现栈(头插法) ===========
    // 功能: 入栈、出栈
    public static class MyStack implements Stack<Integer> {

        private ListNode head;

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
        public void push(Integer val) {
            ListNode cur = new ListNode(val);
            cur.next = head;
            head = cur;
            size++;
        }

        @Override
        public Integer poll() {
            if (head == null) {
                return null;
            }
            Integer ans = head.val;
            head = head.next;
            size--;
            return ans;
        }

        @Override
        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.val;
        }
    }

}
