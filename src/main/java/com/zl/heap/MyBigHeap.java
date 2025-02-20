package com.zl.heap;

import com.zl.heap.interfaces.Heap;
import com.zl.tiku._4_随机数概率问题;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
        while (arr[targetIndex] > arr[(targetIndex - 1) / 2] ) {
            swap(arr, (targetIndex - 1) / 2, targetIndex);
            targetIndex = (targetIndex - 1) / 2;
        }
    }

    @Override
    public Integer poll() {
        if (size() == 0) {
            return null;
        }
        Integer ans = arr[0];
        swap(arr, 0, --size);
        arr[size] = null; // help GC
        // 下面的一个小数放到了根节点，需要下沉，找到合适的位置。
        // 从左右孩子找到大的孩子进行比较，如果它是大的不需要沉，此处正合适。否则进行交换下沉。
        int index = 0;
        int left = 1;
        while (left < size) {
            // 找最大孩子
            int maxChild = left + 1 == size ? left : arr[left] >= arr[left + 1] ? left : left + 1;
            if (arr[maxChild] <= arr[index]) {
                break;
            }
            swap(arr, index, maxChild);
            index = maxChild;
            left = index * 2 + 1;
        }
        return ans;
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
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数器
    public static void main(String[] args) {
        System.out.println("测试开始");
        int times = 1000000;
        int maxValue = 1000;
        int maxLength = 100;
        boolean success = true;
        for (int i = 0; i < times; i++) {
            int length = _4_随机数概率问题.equalProbability5(maxLength) + 1;
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            MyBigHeap bigHeap = new MyBigHeap(length);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                int num = _4_随机数概率问题.equalProbability6(maxValue);
                queue.add(num);
                bigHeap.add(num);
                list.add(num);
            }
            for (int j = 0; j < length; j++) {
                if (!bigHeap.poll().equals(queue.poll())) {
                    success = false;
                    break;
                }
            }
            if (!success) {
                System.out.println("fail :" + list);
                break;
            }
        }
        if (success) {
            System.out.println("Nice");
        }
    }
}
