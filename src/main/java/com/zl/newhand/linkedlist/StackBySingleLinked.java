package com.zl.newhand.linkedlist;

import com.zl.newhand.linkedlist.interfaces.Stack;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 23:37
 * @Description : 单链表实现栈(FILO 头插法)
 */
public class StackBySingleLinked<V> implements Stack<V> {

    public static void main(String[] args) {
        StackBySingleLinked<Integer> stack = new StackBySingleLinked<Integer>();
        stack.push(1);
        stack.push(9);
        stack.push(8);
        stack.push(2);
        stack.push(6);
        stack.push(5);
        int leng = stack.size();
        for (int i = 0; i < leng; i++) {
            System.out.println(stack.peek());
            System.out.println(stack.poll());
            System.out.println("========");
        }
    }

    // 头
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
        Node<V> node = new Node<>(v);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public V poll() {
        if (head == null) {
            return null;
        }
        V oldValue = head.value;
        head = head.next;
        size--;
        return oldValue;
    }

    @Override
    public V peek() {
        return head == null ? null : head.value;
    }

    private static class Node<V> {
        private V value;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }
}
