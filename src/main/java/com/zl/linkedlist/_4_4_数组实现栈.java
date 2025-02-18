package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Stack;

/**
 */
public class _4_4_数组实现栈 {

    public static class MyStack implements Stack<Integer> {

        private final Integer[] data;

        private int size;

        public MyStack(int size) {
            this.data = new Integer[size];
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
        public void push(Integer val) {
            if (size == data.length) {
                throw new IllegalArgumentException();
            }
            data[size++] = val;
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                return null;
            }
            Integer ans = data[--size];
            data[size] = null; // 防止内存泄漏
            return ans;
        }

        @Override
        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return data[size - 1];
        }
    }

}
