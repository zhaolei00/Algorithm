package com.zl.heap;

import com.zl.heap.interfaces.Heap;

import java.util.*;

/**
 * 加强堆(都是小根堆，具体用comparator比较器来进行比较。如果用大根堆，写比较器即可)
 */
public class MyEnhanceHeap<T> implements Heap<T> {

    private final List<T> list;

    private final Map<T, Integer> map;

    private final Comparator<T> comparator;

    public MyEnhanceHeap(Comparator<T> comparator) {
        list = new ArrayList<>();
        map = new HashMap<>();
        this.comparator = comparator;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(T t) {
        list.add(t);
        map.put(t, list.size() - 1);
        shangFu(list.size() - 1);
    }

    @Override
    public T poll() {
        int size = list.size();
        swap(0, size - 1);
        T remove = list.remove(--size);
        map.remove(remove);
        xiaChen(0);
        return remove;
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public boolean contains(T t) {
        return map.containsKey(t);
    }

    @Override
    public int getIndex(T t) {
        return map.get(t);
    }

    @Override
    public void resign(T t) {
        Integer index = map.get(t);
        if (index == null) {
            return;
        }
        // 这里能同时用index，是因为上沉和下浮只能走一个。不然t所在的位置会随着上浮或下沉而变化。
        shangFu(index);
        xiaChen(index);
    }

    @Override
    public void set(int index, T t) {
        T old = list.set(index, t);
        map.remove(old);
        map.put(t, index);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void remove(T t) {
        T target = list.get(size() - 1);
        // 把待删除的数据放到最后
        swap(map.get(t), size() - 1);
        // 数据删除
        T remove = list.remove(size() - 1);
        // 索引删除
        map.remove(remove);
        // 整理。上浮或下沉。
        resign(target);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(list);
    }

    // 上浮
    private void shangFu(int targetIdx) {
        // 小于父节点
        while (comparator.compare(list.get(targetIdx), list.get((targetIdx - 1) / 2)) < 0) {
            // 交换
            swap(targetIdx, (targetIdx - 1) / 2);
            targetIdx = (targetIdx - 1) / 2;
        }
    }

    private void xiaChen(int targetIdx) {
        int left = targetIdx * 2 + 1;
        while (left < size()) {
            int minChile = left + 1 < size()
                    && comparator.compare(list.get(left + 1), list.get(left)) < 0 ? left + 1 : left;
            if (comparator.compare(list.get(targetIdx), list.get(minChile)) <= 0) {
                break;
            }
            swap(targetIdx, minChile);
            targetIdx = minChile;
            left = targetIdx * 2 + 1;
        }
    }

    private void swap(int i, int j) {
        // 数据交换
        T ii = list.get(i);
        T jj = list.get(j);
        list.set(i, jj);
        list.set(j, ii);
        // 索引交换
        map.put(ii, j);
        map.put(jj, i);
    }

    public static void main(String[] args) {
        MyEnhanceHeap<Integer> heap = new MyEnhanceHeap<>(Comparator.comparingInt(o -> o));
        heap.add(5);
        System.out.println(heap.peek());
        System.out.println(heap.poll());
    }
}
