package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 *
 */
public class 链表实现队列 {

    // =========== 单链表实现队列 ===========
    // 功能: 增、取、看
    @Data
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public void offer(V v) {
            Node<V> cur = new Node<>(v);
            if (head == null) {
                head = tail = cur;
            } else {
                tail.setNext(cur);
                tail = cur;
            }
            size++;
        }

        public V poll() {
            if (head == null) {
                return null;
            }
            V ans = head.getV();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            return ans;
        }

        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.getV();
            }
            return ans;
        }
    }

    // =========== 双链表实现双端队列 ===========
    // 功能: 头增、头取、头看、尾增、尾取、尾看
    // tips: 单链表为什么不能实现双端队列?
    //       因为头增、头取、尾增用单链表都能实现，但是尾取实现不了。因为取完尾后，tail找不到上一个节点。只能从前面遍历。那么复杂度就不是o(1),而是o(n)了。
    @Data
    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public void headOffer(V v) {
            Node<V> cur = new Node<>(v);
            if (head == null) {
                head = tail = cur;
            } else {
                cur.setNext(head);
                head.setPre(cur);
                head = cur;
            }
            size++;
        }

        public V headPoll() {
            if (head == null) {
                return null;
            }
            V ans = head.getV();
            size--;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPre(null);
            }
            return ans;
        }

        public V headPeek() {
            V ans = null;
            if (head != null) {
                ans = head.getV();
            }
            return ans;
        }

        public void tailOffer(V v) {
            Node<V> cur = new Node<>(v);
            if (head == null) {
                head = tail = cur;
            } else {
                cur.setPre(tail);
                tail.setNext(cur);
                tail = cur;
            }
            size++;
        }

        public V tailPoll() {
            if (head == null) {
                return null;
            }
            V ans = tail.getV();
            size--;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getPre();
                tail.setNext(null);
            }
            return ans;
        }

        public V tailPeek() {
            V ans = null;
            if (tail != null) {
                ans = tail.getV();
            }
            return ans;
        }
    }

}
