package org.example.newhand.linkedlist;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/8 23:38
 * @Description : 队列 FIFO
 */
public interface Queue<T> {

    /**
     * 是否为空队列
     */
    boolean isEmpty();

    /**
     * 队列长度
     */
    int size();

    /**
     * 入队
     */
    void offer(T t);

    /**
     * 出队
     */
    T poll();

    /**
     * 偷窥
     */
    T peek();
}
