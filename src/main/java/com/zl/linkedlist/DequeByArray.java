package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Deque;

/**
 * 双端队列 数组实现
 */
public class DequeByArray<T> implements Deque<T> {

    private Object[] arr;

    private int head = 0;

    private int tail = 1;

    private int size = 0;

    private int capacity;

    public DequeByArray(int capacity) {
        arr = new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void firstOffer(T t) {
        if (size == capacity) {
            throw new IllegalArgumentException();
        }
        arr[head] = t;
        head = beforeIndex(head);
        size++;
    }

    @Override
    public void lastOffer(T t) {
        if (size == capacity) {
            throw new IllegalArgumentException();
        }
        arr[tail] = t;
        tail = nextIndex(tail);
        size++;
    }

    @Override
    public T firstPoll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        head = nextIndex(head);
        size--;
        return (T) arr[head];
    }

    @Override
    public T lastPoll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        tail = beforeIndex(tail);
        size--;
        return (T) arr[tail];
    }

    private int nextIndex(int index) {
        return index < capacity - 1 ? index + 1 : 0;
    }

    private int beforeIndex(int index) {
        return index == 0 ? capacity - 1 : index - 1;
    }

    public static void main(String[] args) {
        DequeByArray<Integer> deque = new DequeByArray<>(10);
        deque.lastOffer(1);
        deque.firstOffer(3);
        deque.firstOffer(5);
        deque.lastOffer(6);
        deque.lastOffer(9);
        int size1 = deque.size();
        for (int i = 0; i < size1; i++) {
            System.out.println(deque.firstPoll());
        }
    }
}
