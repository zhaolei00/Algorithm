package com.zl.heap;

import com.zl.heap.interfaces.Heap;

/**
 * 大根堆
 */
public class MyBigHeap implements Heap<Integer> {

    private Integer[] arr;

    private int size;

    public MyBigHeap(int size) {
        arr = new Integer[size];
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
    public void add(Integer val) {
        if (size() == arr.length) {
            kuo();
        }
        int targetIndex = size;
        arr[size++] = val;
        while (arr[targetIndex] > arr[(targetIndex - 1) >> 1] ) {
            swap(arr, (targetIndex - 1) >> 1, targetIndex);
            targetIndex = targetIndex - 1;
        }
    }

    @Override
    public Integer poll() {
        return null;
    }

    private void kuo() {
        Integer[] copy = new Integer[size * 2];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
