package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Queue;
import com.zl.linkedlist.interfaces.Stack;

/**
 * 链表算法题集合
 */
public class QuestionCollection {

    public static void main(String[] args) {
        StackByQueue stack = new StackByQueue();
        stack.push(1);
        stack.push(7);
        stack.push(9);
        stack.push(5);
        stack.push(3);
        stack.push(8);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.poll());
        }
    }

    //===============【题目1】设计一个特殊栈，获取栈中最小值时时间复杂度为o(1)=====================
    private static class MinStack {

        private 单链表实现栈.MyStack dataStack;
        private 单链表实现栈.MyStack mixStack;

        public void push(Integer val) {
            dataStack.push(val);
            if (mixStack.isEmpty()) {
                mixStack.push(val);
            } else {
                Integer peek = mixStack.peek();
                if (val < peek) {
                    mixStack.push(val);
                } else {
                    mixStack.push(peek);
                }
            }
        }

        public Integer pop() {
            mixStack.poll();
            return dataStack.poll();
        }

        public Integer getMix() {
            return mixStack.peek();
        }
    }

    //===============【题目2】如何用栈结构实现普通队列结构=====================
    // 思路: 两个栈 push栈 pop栈
    private static class QueueByStack implements Queue<Integer> {

        private final Stack<Integer> pushStack = new 单链表实现栈.MyStack();
        private final Stack<Integer> popStack = new 单链表实现栈.MyStack();
        ;

        @Override
        public boolean isEmpty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }

        @Override
        public int size() {
            return pushStack.size() + popStack.size();
        }

        @Override
        public void offer(Integer val) {
            pushStack.push(val);
        }

        @Override
        public Integer poll() {
            if (popStack.isEmpty() && !pushStack.isEmpty()) {
                transform(pushStack, popStack);
            }
            return popStack.poll();
        }

        @Override
        public Integer peek() {
            if (popStack.isEmpty() && !pushStack.isEmpty()) {
                transform(pushStack, popStack);
            }
            return pushStack.peek();
        }

        private void transform(Stack<Integer> originalStack, Stack<Integer> targetStack) {
            while (!originalStack.isEmpty()) {
                targetStack.push(originalStack.poll());
            }
        }
    }

    //===============【题目3】如何用普通队列结构实现栈结构=====================
    // 思路: 两个队列 data队列 help队列 在取数据时，help队列用于数据转化，data和help交换
    private static class StackByQueue implements Stack<Integer> {

        private Queue<Integer> dataQueue = new 链表实现队列.MyQueue();
        private Queue<Integer> helpQueue = new 链表实现队列.MyQueue();

        @Override
        public boolean isEmpty() {
            return dataQueue.isEmpty();
        }

        @Override
        public int size() {
            return dataQueue.size();
        }

        @Override
        public void push(Integer val) {
            dataQueue.offer(val);
        }

        @Override
        public Integer poll() {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            }
            return transformQueue(false);
        }

        @Override
        public Integer peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            }
            return transformQueue(true);
        }

        public Integer transformQueue(boolean isPeek) {
            int size = dataQueue.size();
            for (int i = 0; i < size - 1; i++) {
                helpQueue.offer(dataQueue.poll());
            }
            Integer value = dataQueue.poll();
            if (isPeek) {
                helpQueue.offer(value);
            }
            Queue<Integer> temp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = temp;
            return value;
        }
    }

}
