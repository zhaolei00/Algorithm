package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Deque;
import com.zl.linkedlist.interfaces.Queue;

/**
 */
public class _4_3_数组实现队列 {

    public static class MyQueue implements Queue<Integer> {

        private Integer[] data;

        private int head; // 头位置(可取)

        private int tail; // 尾位置(可取)

        private int size;

        public MyQueue(int size) {
            data = new Integer[size];
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
        public void offer(Integer val) {
            if (size() == data.length) {
                throw new IllegalArgumentException();
            }
            data[tail++] = val;
            if (tail == data.length) {
                tail = 0;
            }
            size++;
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            }
            Integer ans = data[head++];
            if (head == data.length) {
                head = 0;
            }
            size--;
            return ans;
        }

        @Override
        public Integer peek() {
            return data[head];
        }
    }

    public static class MyDeque implements Deque<Integer> {

        private Integer[] data;

        private int head = 0; // 可以插入的下标

        private int tail = 1; // 可以插入的下标

        private int size;

        public MyDeque(int size) {
            data = new Integer[size];
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
        public void firstOffer(Integer val) {
            if (size == data.length) {
                throw new IllegalArgumentException();
            }
            data[head--] = val;
            if (head == -1) {
                head = data.length - 1;
            }
            size++;
        }

        @Override
        public void lastOffer(Integer val) {
            if (size == data.length) {
                throw new IllegalArgumentException();
            }
            data[tail++] = val;
            if (tail == data.length) {
                tail = 0;
            }
            size++;
        }

        @Override
        public Integer firstPoll() {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            }
            head++;
            if (head == data.length) {
                head = 0;
            }
            size--;
            return data[head];
        }

        @Override
        public Integer lastPoll() {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            }
            tail--;
            if (tail == -1) {
                tail = data.length - 1;
            }
            size--;
            return data[tail];
        }
    }

}
