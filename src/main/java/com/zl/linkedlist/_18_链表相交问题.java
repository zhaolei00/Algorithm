package com.zl.linkedlist;

/**
 */
public class _18_链表相交问题 {

    /**
     *【题目】给定两个链表，有可能有环。返回第一个相交节点，无返回空。
     */
    public ListNode question1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode ring1 = ringFirstNode(head1);
        ListNode ring2 = ringFirstNode(head2);
        // 两个无环计算相交节点
        if (ring1 == null && ring2 == null) {
            return jiaoNotRing(head1, head2, null);
        }
        // 一个有环，一个无环，一定没有相交节点
        if (ring1 == null || ring2 == null) {
            return null;
        }

        // 环前相交
        if (ring1 == ring2) {
            return jiaoNotRing(head1, head2, ring1.next);
        }
        ListNode temp = ring1.next;
        while (temp != ring1) {
            // 有相交，在环的不同点，返回其中一个即可。
            if (temp == ring2) {
                return temp;
            }
            temp = temp.next;
        }
        // 两个环无相交
        return null;
    }

    private ListNode ringFirstNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 环
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null; // 无环
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private ListNode jiaoNotRing(ListNode head1, ListNode head2, ListNode targetNode) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode tail1 = head1;
        ListNode tail2 = head2;
        int size1 = 1;
        int size2 = 1;
        while (tail1.next != targetNode) {
            tail1 = tail1.next;
            size1++;
        }
        while (tail2.next != targetNode) {
            tail2 = tail2.next;
            size2++;
        }
        // 尾节点不一样，一定不相交
        if (tail1 != tail2) {
            return null;
        }
        ListNode minHead = size1 <= size2 ? head1 : head2;
        ListNode maxHead = minHead == head1 ? head2 : head1;
        int diffNum = Math.abs(size1 - size2);
        while (diffNum > 0) {
            maxHead = maxHead.next;
            diffNum--;
        }
        while (minHead != maxHead) {
            minHead = minHead.next;
            maxHead = maxHead.next;
        }
        return minHead;
    }

    private ListNode jiaoHaveRing(ListNode ringA, ListNode ringB) {

    }

}
