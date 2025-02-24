package com.zl.linkedlist;

/**
 */
public class _17_复制链表有额外指针 {

    public static class ListNodeWithRand {

        // 值
        public int val;

        // 后继节点
        public ListNodeWithRand next;

        public ListNodeWithRand rand;

        public ListNodeWithRand(int val) {
            this.val = val;
        }
    }

    /**
     *【题目】复制ListNodeWithRand 链表，里面的rand指针也需要复制
     */
    public static ListNodeWithRand question1(ListNodeWithRand head) {
        if (head == null) {
            return null;
        }
        ListNodeWithRand cur = head;
        ListNodeWithRand next;
        // 链表已经复制一半
        while (cur != null) {
            next = cur.next;
            ListNodeWithRand newNode = new ListNodeWithRand(cur.val);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        cur = head;
        // 连接rand指针
        while (cur != null) {
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }
        // 连接完rand指针，删除在原链表上
        ListNodeWithRand ans = head.next;
        cur = head;
        ListNodeWithRand copyNode;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next == null ? null : next.next;
            cur = next;
        }
        return ans;
    }

}
