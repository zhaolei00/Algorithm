package com.zl.newhand.linkedlist;

import com.zl.newhand.linkedlist.interfaces.Queue;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 23:37
 * @Description : 单链表实现队列(FIFO, 尾差法)
 */
public class QueueBySingleLinked<T> implements Queue<T> {

    public static void main(String[] args) {
        QueueBySingleLinked<Integer> q = new QueueBySingleLinked<>();
        q.offer(2);
        q.offer(8);
        q.offer(2);
        q.offer(11);
        q.offer(9);
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println("==========");
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println("==========");
        System.out.println(q.isEmpty());
        System.out.println(q.size);
        System.out.println(q.peek());
        System.out.println(q.poll());
    }

    // 头
    private Node<T> head;

    // 尾
    private Node<T> tail;

    // 队列长度
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
    public void offer(T t) {
        Node<T> node = new Node<>(t);
        if (tail == null) {
            // init head tail
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        }
        T oldValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldValue;
    }

    @Override
    public T peek() {
        return head == null ? null : head.value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
