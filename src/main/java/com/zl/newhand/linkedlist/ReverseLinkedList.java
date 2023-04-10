package com.zl.newhand.linkedlist;

import lombok.Data;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 22:11
 * @Description : 反转链表相关算法
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        node1.pre = null;
        Node<Integer> node2 = new Node<>(2);
        node1.next = node2;
        node2.pre = node1;
        Node<Integer> node3 = new Node<>(3);
        node2.next = node3;
        node3.pre = node2;
        Node<Integer> ans = new ReverseDoubleLinkedList<Integer>().reverse(node1);
        Node<Integer> tail = null;
        while (ans != null) {
            System.out.print(ans.value + "->");
            tail = ans;
            ans = ans.next;
        }
        System.out.println("null");
        while (tail != null) {
            System.out.print(tail.value + "->");
            tail = tail.pre;
        }
        System.out.println("null");
    }

    //===============【题目】给定单向链表Head, 进行反转=====================
    private static class ReverseSingleLinkedList<E> {
        public Node<E> reverse(Node<E> head) {
            Node<E> pre = null;
            Node<E> next = null;
            while (head != null) {
                // head 记录要反转的节点
                // pre 记录要反转的前一个节点
                // next 记录要反转的后一个节点
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    //===============【题目】给定双向链表Head, 进行反转=====================
    private static class ReverseDoubleLinkedList<E> {
        public Node<E> reverse(Node<E> head) {
            Node<E> pre = null;
            Node<E> next = null;
            while (head != null) {
                // head 记录要反转的节点
                // pre 记录要反转的前一个节点
                // next 记录要反转的后一个节点
                next = head.next;
                head.next = pre;
                head.pre = next;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    @Data
    private static class Node<T> {
        private T value;

        private Node<T> pre;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
