package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Queue;
import com.zl.linkedlist.interfaces.Stack;

/**
 * 链表算法题集合
 */
public class QuestionCollection {

    //===============【题目1】设计一个特殊栈，获取栈中最小值时时间复杂度为o(1)=====================
    private static class MinStack {

        private _5_单链表实现栈.MyStack dataStack;
        private _5_单链表实现栈.MyStack mixStack;

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

        private final Stack<Integer> pushStack = new _5_单链表实现栈.MyStack();
        private final Stack<Integer> popStack = new _5_单链表实现栈.MyStack();
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

}
