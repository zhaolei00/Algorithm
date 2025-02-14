package com.zl.linkedlist;

import com.zl.linkedlist.interfaces.Stack;

/**
 * 栈 数组实现
 */
public class StackByArray<T> implements Stack<T> {

    private Object[] arr;

    private int index = 0;


    public StackByArray(int size) {
        this.arr = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void push(T t) {
        if (index == arr.length) {
            throw new IllegalArgumentException();
        }
        arr[index++] = t;
    }

    @Override
    public T poll() {
        if (index == 0) {
            throw new IllegalArgumentException();
        }
        return (T) arr[--index];
    }

    @Override
    public T peek() {
        if (index == 0) {
            return null;
        }
        return (T) arr[index - 1];
    }

    public static void main(String[] args) {
        StackByArray<Integer> stack = new StackByArray<>(5);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(5);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.peek());
            System.out.println(stack.poll());
        }
    }
}
