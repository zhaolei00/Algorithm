package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Queue;

/**
 */
public class _8_数组实现队列 {

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

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.offer(4);
        myQueue.offer(7);
        myQueue.offer(6);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }
        myQueue.offer(1);
        myQueue.offer(3);
        myQueue.offer(2);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }


    }

}
