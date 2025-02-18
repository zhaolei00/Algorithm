package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Queue;

/**
 */
public class _5_2_栈实现普通队列 {

    public static class MyQueue implements Queue<Integer> {

        private _4_2_单链表实现栈.MyStack push = new _4_2_单链表实现栈.MyStack();

        private _4_2_单链表实现栈.MyStack pop = new _4_2_单链表实现栈.MyStack();

        @Override
        public boolean isEmpty() {
            return push.isEmpty() && pop.isEmpty();
        }

        @Override
        public int size() {
            return push.size() + pop.size();
        }

        @Override
        public void offer(Integer val) {
            push.push(val);
        }

        @Override
        public Integer poll() {
            if (!pop.isEmpty()) {
                return pop.poll();
            }
            while (!push.isEmpty()) {
                pop.push(push.poll());
            }
            return pop.poll();
        }

        @Override
        public Integer peek() {
            if (!pop.isEmpty()) {
                return pop.peek();
            }
            while (!push.isEmpty()) {
                pop.push(push.poll());
            }
            return pop.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(4);
        myQueue.offer(9);
        myQueue.offer(7);
        myQueue.offer(3);
        myQueue.offer(5);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }
    }

}
