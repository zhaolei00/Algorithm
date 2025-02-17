package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Queue;

/**
 */
public class _5_2_栈实现普通队列 {

    public static class MyQueue implements Queue<Integer> {

        private _4_2_单链表实现栈.MyStack data = new _4_2_单链表实现栈.MyStack();

        private _4_2_单链表实现栈.MyStack help = new _4_2_单链表实现栈.MyStack();

        @Override
        public boolean isEmpty() {
            return data.isEmpty();
        }

        @Override
        public int size() {
            return data.size();
        }

        @Override
        public void offer(Integer val) {
            data.push(val);
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                return null;
            }
            int size = data.size();
            for (int i = 0; i < size - 1; i++) {
                help.push(data.poll());
            }
            Integer ans = data.poll();
            while (!help.isEmpty()) {
                data.push(help.poll());
            }
            return ans;
        }

        @Override
        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            int size = data.size();
            Integer ans = null;
            for (int i = 0; i < size; i++) {
                Integer poll = data.poll();
                ans = poll;
                help.push(poll);
            }
            while (!help.isEmpty()) {
                data.push(help.poll());
            }
            return ans;
        }
    }

}
