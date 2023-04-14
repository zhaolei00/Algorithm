package com.zl.newhand.linkedlist;

import com.zl.newhand.linkedlist.interfaces.Queue;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/14 13:38
 * @Description : 队列数组实现
 */
public class QueueByArray<T> implements Queue<T> {

    private Object[] arr;

    public QueueByArray(int size) {
        this.arr = new Object[size];
    }

    private int left = 0;

    private int right = 0;

    private int size = 0;

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
        if (size == arr.length) {
            throw new IllegalArgumentException();
        }
        arr[right] = t;
        right = nextIndex(right);
        size++;
    }

    @Override
    public T poll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        T old = (T) arr[left];
        left = nextIndex(left);
        size--;
        return old;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) arr[left];
    }

    private int nextIndex(int index) {
        return index < arr.length - 1 ? index + 1 : 0;
    }

    public static void main(String[] args) {
        QueueByArray<Integer> list = new QueueByArray<>(5);
        list.offer(1);
        list.offer(9);
        list.offer(3);
        list.offer(7);
        System.out.println(list.peek());
        System.out.println(list.poll());
        list.offer(7);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.peek());
            System.out.println(list.poll());
        }
    }
}
