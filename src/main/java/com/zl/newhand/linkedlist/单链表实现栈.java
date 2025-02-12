package com.zl.newhand.linkedlist;

import com.zl.newhand.linkedlist.interfaces.Stack;

/**
 *
 */
public class 单链表实现栈 {

    // =========== 单链表实现栈(头插法) ===========
    // 功能: 入栈、出栈
    public static class MyStack<V> implements Stack<V> {

        private Node<V> head;

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
        public void push(V v) {
            Node<V> cur = new Node<>(v);
            cur.setNext(head);
            head = cur;
            size++;
        }

        @Override
        public V poll() {
            if (head == null) {
                return null;
            }
            V ans = head.getV();
            head = head.getNext();
            size--;
            return ans;
        }

        @Override
        public V peek() {
            if (head == null) {
                return null;
            }
            return head.getV();
        }
    }

}
