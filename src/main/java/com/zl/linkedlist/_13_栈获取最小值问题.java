package com.zl.linkedlist;

/**
 */
public class _13_栈获取最小值问题 {

    //===============【题目1】设计一个特殊栈，获取栈中最小值时时间复杂度为o(1)=====================
    public static class MinStack {
        private _5_单链表实现栈.MyStack data = new _5_单链表实现栈.MyStack();
        private _5_单链表实现栈.MyStack minStack = new _5_单链表实现栈.MyStack();

        public void push(Integer val) {
            data.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                Integer peek = minStack.peek();
                if (val < peek) {
                    minStack.push(val);
                } else {
                    minStack.push(peek);
                }
            }
        }

        public Integer poll() {
            minStack.poll();
            return data.poll();
        }

        public Integer getMin() {
            return minStack.peek();
        }

    }

}
