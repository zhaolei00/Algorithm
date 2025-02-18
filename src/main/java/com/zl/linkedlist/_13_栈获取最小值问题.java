package com.zl.linkedlist;

/**
 */
public class _13_栈获取最小值问题 {

    //===============【题目1】设计一个特殊栈，获取栈中最小值时时间复杂度为o(1)=====================
    public static class MinStack {

        private _4_2_单链表实现栈.MyStack data = new _4_2_单链表实现栈.MyStack();

        private _4_2_单链表实现栈.MyStack help = new _4_2_单链表实现栈.MyStack();

        public void push(Integer val) {
            data.push(val);
            if (help.isEmpty()) {
                help.push(val);
            } else {
                Integer peek = help.peek();
                if (val < peek) {
                    help.push(val);
                } else {
                    help.push(peek);
                }
            }
        }

        public Integer poll() {
            help.poll();
            return data.poll();
        }

        public Integer getMin() {
            return help.peek();
        }
    }

}
