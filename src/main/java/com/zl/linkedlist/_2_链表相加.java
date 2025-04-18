package com.zl.linkedlist;

import com.zl.tiku._99_对数器;

/**
 */
public class _2_链表相加 {

    //===============【题目】=====================
    // 给定两个链表的头节点 head1和head2，认为从左到右是某个数字从地位到高位，返回相加之后的链表。
    // 例子: head1: 2 > 4 > 6   head2: 3 > 8 > 4
    // 返回: 5 > 2 > 1 > 1
    // 解释: 642 + 483 = 1125
    // 思路: 前提: 分为长短链表，长:l 短:s 分为三个阶段: l有s有，l有s没有，l没有s没有

    public static ListNode linkedAddSum(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        int length1 = length(head1);
        int length2 = length(head2);
        ListNode lengthMinHead = length1 <= length2 ? head1 : head2;
        ListNode lengthMaxHead = lengthMinHead == head1 ? head2 : head1;
        // 以短的为主，开始遍历进行相加。短的遍历完成后，链上长的剩余的。
        int carry = 0;
        ListNode ans = lengthMaxHead;
        ListNode pre = null;
        while (lengthMaxHead != null) {
            pre = lengthMaxHead;
            if (lengthMinHead != null) {
                int sum = lengthMinHead.val + lengthMaxHead.val + carry;
                carry = sum / 10;
                lengthMaxHead.val = sum % 10;
                lengthMaxHead = lengthMaxHead.next;
                lengthMinHead = lengthMinHead.next;
            } else {
                if (carry == 0) {
                    break;
                }
                int sum = lengthMaxHead.val + carry;
                carry = sum / 10;
                lengthMaxHead.val = sum % 10;
                lengthMaxHead = lengthMaxHead.next;
            }
        }
        // 所有节点都处理完，还有进位，新建个节点
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return ans;
    }

    public static int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private static void test() {
        int times = 3;
        int maxLength = 5;
        int maxValue = 9;
        for (int i = 0; i < times; i++) {
            ListNode listNode1 = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(listNode1);
            ListNode listNode2 = _99_对数器.randomGenLinkedList(maxLength, maxValue);
            _99_对数器.printSingleLinked(listNode2);
            ListNode sum = linkedAddSum(listNode1, listNode2);
            _99_对数器.printSingleLinked(sum);
            System.out.println("======");
        }
    }

    public static void main(String[] args) {
        test();
    }

}
