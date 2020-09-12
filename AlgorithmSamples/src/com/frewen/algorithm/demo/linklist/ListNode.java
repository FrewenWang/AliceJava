package com.frewen.algorithm.demo.linklist;


import java.util.LinkedList;
import java.util.List;

/**
 * 定义一个单链表
 * Java实现单链表：https://cloud.tencent.com/developer/article/1080633
 */
public class ListNode<T> {

    T val;

    ListNode next;

    /**
     * 单链表的构造函数
     *
     * @param x
     */
    ListNode(T x) {
        val = x;
    }

    public ListNode(T data, ListNode next) {
        this.val = data;
        this.next = next;
    }

    /**
     * 链表的初始化
     * @return
     */
    public static ListNode initListNode() {
        ListNode listNode = new ListNode<>(2);
        listNode.next = new ListNode<>(4);
        listNode.next.next = new ListNode<>(3);
        listNode.next.next.next = new ListNode<>(10);
        listNode.next.next.next.next = new ListNode<>(5);
        listNode.next.next.next.next.next = new ListNode<>(9);
        listNode.next.next.next.next.next.next = new ListNode<>(7);
        listNode.next.next.next.next.next.next.next = new ListNode<>(11);
        return listNode;
    }
    /**
     * 向链表添加数据
     * 需要找到当前链表的头结点。然后根据头结点进行遍历，然后遍历增加
     *
     * @param value 要添加的数据
     */
    public static <T> void addData(ListNode head, T value) {
        //初始化要加入的节点
        ListNode newNode = new ListNode(value);

        //临时节点
        ListNode temp = head;

        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        // 已经包括了头节点.next为null的情况了～
        temp.next = newNode;
    }

    /**
     * 遍历链表:
     *
     * @param head 头节点
     */
    public static void traverse(ListNode head) {
        //临时节点，从首节点开始
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + "->");
            //继续下一个
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    /**
     * 使用递归方法进行单链表
     * 单链表节点的反转。
     * 主体思想就是：使用递归方法一次遍历每个节点。
     *
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private static ListNode reverseBy(ListNode head) {
        // 将ListNode的顶一个pre节点指向null
        ListNode pre = null;
        // 当前节点current指向head
        ListNode current = head;

        while (current != null) {
            // 我们先保存一下链表的下一个节点。
            ListNode next = current.next;
            // 因为需要反转，所以我们将当前节点的下一个节点指向pre
            current.next = pre;
            // pre再指向当前节点
            pre = current;
            //
            current = next;
        }
        return pre;
    }


    /**
     * 插入节点
     *
     * @param head  头指针
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public static void insertNode(ListNode head, int index, int value) {


        //首先需要判断指定位置是否合法，
        if (index < 1 || index > linkListLength(head) + 1) {
            System.out.println("插入位置不合法。");
            return;
        }

        //临时节点，从头节点开始
        ListNode temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        //初始化要插入的节点
        ListNode insertNode = new ListNode(value);

        while (temp.next != null) {
            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {
                //temp表示的是上一个节点
                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;
                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;
                return;

            }

            currentPos++;
            temp = temp.next;
        }

    }

    /**
     * 获取链表的长度
     *
     * @param head 头指针
     */
    public static int linkListLength(ListNode head) {

        int length = 0;

        //临时节点，从首节点开始
        ListNode temp = head.next;

        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

}
