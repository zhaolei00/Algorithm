package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Stack;

/**
 */
public class _10_普通队列实现栈 {

    public static class MyStack implements Stack<Integer> {

        private _4_链表实现队列.MyQueue data = new _4_链表实现队列.MyQueue();

        private _4_链表实现队列.MyQueue help = new _4_链表实现队列.MyQueue();

        @Override
        public boolean isEmpty() {
            return data.isEmpty();
        }

        @Override
        public int size() {
            return data.size();
        }

        @Override
        public void push(Integer val) {
            data.offer(val);
        }

        @Override
        public Integer poll() {
            if (data.isEmpty()) {
                return null;
            }
            int dataSize = data.size();
            while (dataSize-- > 1) {
                help.offer(data.poll());
            }
            Integer ans = data.poll();
            _4_链表实现队列.MyQueue temp = data;
            data = help;
            help = temp;
            return ans;
        }

        @Override
        public Integer peek() {
            if (data.isEmpty()) {
                return null;
            }
            int dataSize = data.size();
            Integer ans = null;
            while (dataSize-- > 0) {
                Integer poll = data.poll();
                ans = poll;
                help.offer(poll);
            }
            _4_链表实现队列.MyQueue temp = data;
            data = help;
            help = temp;
            return ans;
        }
    }

}
