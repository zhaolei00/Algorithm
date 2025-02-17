package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Deque;
import com.zl.linkedlist.interfaces.Queue;

/**
 */
public class _4_3_数组实现队列 {

    public static class MyQueue implements Queue<Integer> {

        private int[] data;

        private int size;

        private int left;

        private int right;

        public MyQueue(int size) {
            this.data = new int[size];
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
            if (size == data.length) {
                throw new IllegalArgumentException("超过数组长度");
            }
            data[right++] = val;
            right %= data.length;
            size++;
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                return null;
            }
            Integer ans = data[left++];
            left %= data.length;
            size--;
            return ans;
        }

        @Override
        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return data[left];
        }
    }

    public static class MyDeque implements Deque<Integer> {

        private int[] data;

        private int left = 0;

        private int right = 1;

        private int size;

        public MyDeque(int size) {
            this.data = new int[size];
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
            data[left] = val;
            left = left == 0 ? data.length - 1: left - 1;
            size++;
        }

        @Override
        public void lastOffer(Integer val) {
            if (size == data.length) {
                throw new IllegalArgumentException();
            }
            data[right] = val;
            right = right == data.length - 1 ? 0 : right + 1;
            size++;
        }

        @Override
        public Integer firstPoll() {
            if (size == 0) {
                throw new IllegalArgumentException();
            }
            int index = left == data.length - 1 ? 0 : left + 1;
            left = index;
            size--;
            return data[index];
        }

        @Override
        public Integer lastPoll() {
            if (size == 0) {
                throw new IllegalArgumentException();
            }
            int index = right == 0 ? data.length - 1 : right - 1;
            right = index;
            size--;
            return data[index];
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new MyDeque(10);
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
