package com.frewen.algorithm.demo.linklist;

import java.util.List;

/**
 * 链表操作相关算法的集合
 */
public class LinkedListTest {

    public static void main(String[] args) {

        // init ListNode1
        ListNode listNode1 = ListNode.initListNode();
        // init ListNode2
        ListNode listNode2 = new ListNode<Integer>(5);
        listNode2.next = new ListNode<Integer>(6);
        listNode2.next.next = new ListNode<Integer>(4);


        // 单链表的节点的遍历
        listNodeTraverse(listNode1);

        System.out.println("\n单链表的反转:");
        // 单链表的节点的反转
        ListNode reverseListNode = listNodeReverse(listNode1);

        // 单链表的节点的遍历
        listNodeTraverse(reverseListNode);


        addTwoNumbers(listNode1, listNode2);
    }

    /**
     * 单链表节点的反转
     *
     * @param head
     */
    private static ListNode listNodeReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = listNodeReverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private static void listNodeTraverse(ListNode listNode1) {
        while (null != listNode1) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
        System.out.print("NULL");

    }

    private static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        // 实例化一个默认值为0的一个链表节点
        ListNode totalListNode = new ListNode(0);

        ListNode currentNode = totalListNode;
        int carry = 0;
        int totalValue = 0;

        while (null != l1 || null != l2) {
            // 计算链表节点l1 和 l2的value值
            Integer x = (l1 != null) ? l1.val : 0;
            Integer y = (l2 != null) ? l2.val : 0;
            // 计算两个value的节点值的总和，加上进位
            int sum = carry + x + y;
            // 计算 进位制和实际值
            carry = sum / 10;
            totalValue = sum % 10;

            // 实际值存储在下一个节点位置
            currentNode.next = new ListNode(totalValue);
            // 将节点往前移一位
            currentNode = currentNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }


        return totalListNode.next;
    }
}
