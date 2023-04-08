package org.example.newhand.linkedlist;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/9 00:52
 * @Description : 双端队列
 */
public class QueueByDoubleLinked<V> implements Deque<V>{

    public static void main(String[] args) {
        QueueByDoubleLinked<Integer> q = new QueueByDoubleLinked<>();
        q.firstOffer(1);
        q.lastOffer(7);
        q.firstOffer(3);
        q.lastOffer(4);
        q.firstOffer(11);
        q.lastOffer(2); // 11 3 1 7 4 2
        Node<Integer> tmp = q.head;
        while (tmp != null) {
            System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
        System.out.print("->null");
        System.out.println();
        tmp = q.tail;
        while (tmp != null) {
            System.out.print(tmp.value + "->");
            tmp = tmp.pre;
        }
        System.out.print("->null");
        System.out.println();
        System.out.println("====");
        System.out.println(q.firstPoll());
        System.out.println(q.lastPoll());
        System.out.println(q.firstPoll());
        System.out.println(q.firstPoll());
        System.out.println(q.lastPoll());
        System.out.println(q.lastPoll()); // 11 2 3 1 4 7
    }

    private Node<V> head;

    private Node<V> tail;

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
    public void firstOffer(V v) {
        Node<V> node = new Node<>(v);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    @Override
    public void lastOffer(V v) {
        Node<V> node = new Node<>(v);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public V firstPoll() {
        if (head == null) {
            return null;
        }
        V v = head.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        size--;
        return v;
    }

    @Override
    public V lastPoll() {
        if (tail == null) {
            return null;
        }
        V v = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
        return v;
    }

    private static class Node<V> {
        private V value;

        private Node<V> pre;

        private Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }
}
