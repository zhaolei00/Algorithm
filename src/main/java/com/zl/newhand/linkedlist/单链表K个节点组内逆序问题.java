package com.zl.newhand.linkedlist;

/**
 */
public class 单链表K个节点组内逆序问题 {

    //===============【题目】=====================
    // 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
    // k 是一个正整数。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    // 思路: n a->b>c>d m, n 可能没有，也不关系有没有，就当不知道。m最少是个null。 最后 a->b>c>d 反转 d->c>b>a , a->n

    public static <V> Node<V> singleLinkedKGroupReverse(Node<V> head, int k) {
        if (head == null) {
            return head;
        }
        Node<V> start = head;
        Node<V> end = getKEndNode(head, k);
        // 不足，不用反转直接返回
        if (end == null) {
            return head;
        }
        head = end; // 第一组反转完的end，就是头节点，后续不需要关注返回值，只需要关注组内反转。
        // 一定有多组K需要反转
        reverseS2E(start, end);
        Node<V> preStart = start; // 反转k组节点的前一个节点，因为反转后，前一个节点，要指向反转后的头节点。
        while (preStart.getNext() != null) {
            start = preStart.getNext();
            end = getKEndNode(start, k);
            if (end == null) {
                return head;
            }
            reverseS2E(start, end);
            preStart.setNext(end);
            preStart = start;
        }
        return head;
    }

    // 从start节点开始，返回第K个节点，如果不存在返回NULL。
    private static <V> Node<V> getKEndNode(Node<V> start, int k) {
        // 如果节点足够，k-1次到达K个节点。
        while (--k > 0 && start != null) {
            start = start.getNext();
        }
        return start;
    }

    // 反转start到end的节点，并把start的下一个节点，变成end的下一个。
    private static <V> void reverseS2E(Node<V> start, Node<V> end) {
        end = end.getNext();

        Node<V> pre = null;
        Node<V> next;
        Node<V> cur = start; // 也就是反转链表的head，因为最后反转完，第一个节点需要指向end节点，所以不能用start。
        while (cur != end) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }

        start.setNext(end);
    }

}
