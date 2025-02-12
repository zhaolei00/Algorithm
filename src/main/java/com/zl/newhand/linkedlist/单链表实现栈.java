package com.zl.newhand.linkedlist;

/**
 *
 */
public class 单链表实现栈 {

    // =========== 单链表实现栈(头插法) ===========
    // 功能: 入栈、出栈
    public static class MyStack<V> {

        private Node<V> head;

        private int size;

        public void push(V v) {
            Node<V> cur = new Node<>(v);
            cur.setNext(head);
            head = cur;
            size++;
        }

        public V poll() {
            if (head == null) {
                return null;
            }
            V ans = head.getV();
            head = head.getNext();
            size--;
            return ans;
        }

        public V peek() {
            if (head == null) {
                return null;
            }
            return head.getV();
        }
    }

}
