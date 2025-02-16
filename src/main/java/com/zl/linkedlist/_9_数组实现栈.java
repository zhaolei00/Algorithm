package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Stack;

/**
 */
public class _9_数组实现栈 {

    public static class MyStack implements Stack<Integer> {

        private int[] data;
        private int size;

        public MyStack(int size) {
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
        public void push(Integer val) {
            data[size++] = val;
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                return null;
            }
            return data[--size];
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
