package com.zl.newhand.tiku;

import com.zl.newhand.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对数器(正确的比较)
 *     作用:
 *         1. 生成随机样本。
 *         2. 肯定正确的解决流程，不考虑复杂度。
 *         3. 自己写的算法，是否正确，通过随机样本，比较2和3的结果。如果结果有差异，则算法有问题。
 *            根据有问题的case，进行调试，找问题更快。
 */
public class _99_对数器 {

    // TODO 需要补充各种工具。例如: 生成随机长度和随机大小的数组。等等。
    public static void main(String[] args) {
        int times = 10;
        int maxLength = 10;
        int maxValue = 100;
        for (int i = 0; i < times; i++) {
            ListNode head = randomGenLinkedList(maxLength, maxValue);
            printSingleLinked(head);
        }
    }

    public static int[] randomGenIntArray(int maxLength, int maxValue) {
        if (_4_随机数概率问题.equalProbability1() <= 0.1) {
            return null;
        }
        int[] arr = new int[_4_随机数概率问题.equalProbability5(maxLength)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = _4_随机数概率问题.equalProbability5(maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] randomGenNotEqualArray(int maxLength, int maxValue) {
        if (_4_随机数概率问题.equalProbability1() <= 0.1) {
            return null;
        }
        int[] arr = new int[_4_随机数概率问题.equalProbability5(maxLength)];
        if (arr.length > 0) {
            arr[0] = _4_随机数概率问题.equalProbability5(maxValue);
            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = _4_随机数概率问题.equalProbability5(maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 随机生成单向链表
     */
    public static ListNode randomGenLinkedList(int maxLength, int maxValue) {
        int length = _4_随机数概率问题.equalProbability5(maxLength - 1) + 1;
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < length; i++) {
            ListNode temp = new ListNode(_4_随机数概率问题.equalProbability5(maxValue), null);
            if (head == null) {
                head = temp;
                tail = temp;
                continue;
            }
            tail.next = temp;
            tail = temp;
        }
        return head;
    }

    /**
     * 随机生成有序单向链表
     */
    public static ListNode randomGenSortLinkedList(int maxLength, int maxValue) {
        int length = _4_随机数概率问题.equalProbability5(maxLength - 1) + 1;
        ListNode head = null;
        ListNode tail = null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(_4_随机数概率问题.equalProbability5(maxValue));
        }
        Collections.sort(list);
        for (Integer value : list) {
            if (head == null) {
                head = tail = new ListNode(value);
            } else {
                ListNode temp = new ListNode(value);
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    /**
     * 随机生成双向链表
     */
    public static ListNode randomGenDoubleLinkedList(int maxLength, int maxValue) {
        int length = _4_随机数概率问题.equalProbability5(maxLength - 1) + 1;
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < length; i++) {
            ListNode temp = new ListNode(_4_随机数概率问题.equalProbability5(maxValue), null);
            if (head == null) {
                head = temp;
                tail = temp;
                continue;
            }
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
        }
        return head;
    }

    /**
     * 打印单向链表
     */
    public static void printSingleLinked(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

}
