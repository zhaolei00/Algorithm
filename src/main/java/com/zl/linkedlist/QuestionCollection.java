package com.zl.linkedlist;

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

}
