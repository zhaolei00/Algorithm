package com.zl.newhand.linkedlist;

/**
 * @Author : zhaolei
 * @Date : Create in 2023/4/9 01:32
 * @Description : 链表算法题集合
 */
public class QuestionCollection {

    public static void main(String[] args) {
        ReverseKGroup.reverse();
    }

    //===============【题目】=====================
    // 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
    // k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    // 思路: n a->b>c>d m, n 可能没有，也不关系有没有，就当不知道。m最少是个null。 最后 a->b>c>d 反转 d->c>b>a , a->n

    private static class ReverseKGroup {


        private static void reverse() {

        }

    }

    //===============【题目】=====================
    // 给定两个链表的头节点 head1和head2，认为从左到右是某个数字从地位到高位，返回相加之后的链表。
    // 例子: head1: 2 > 4 > 6   head2: 3 > 8 > 4
    // 返回: 0 > 8 > 0 > 1
    // 解释: 642 + 438 = 1080
    // 思路: 前提: 分为长短链表，长:l 短:s 分为三个阶段: l有s有，l有s没有，l没有s没有


    // 两个有序链表合并，给定两个有序链表的头节点 head1和head2
    // 返回合并之后的大链表，依然有序。
    // 思路: head1和head2进行比较，谁小返回谁。定义cur1和cur2和pre，cur1和cur2谁小pre.next连接谁

    //===============【题目】=====================
    //给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
    // 思路: 工具小根堆。 把所有链表的头部放入到小根堆中，取出小根堆的最小值Node，放入node的next放入到小根堆，再重复这个操作，直到小根堆为空。

}
