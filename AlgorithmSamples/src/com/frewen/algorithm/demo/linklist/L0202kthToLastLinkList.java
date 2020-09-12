package com.frewen.algorithm.demo.linklist;
public class L0202kthToLastLinkList {

    public static void main(String[] args) {
        int k = 3;
        ListNode<Integer> listNode = ListNode.initListNode();

        ListNode.traverse(listNode);

        ListNode head = listNode;

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");

        ListNode<Integer> fastNode = listNode;
        ListNode<Integer> slowNode = listNode;

        for (int i = 0; i < k+1; i++) {
            if (fastNode != null) {
                fastNode = fastNode.next;
                ++i;
            }
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        System.out.print("结果是：" + slowNode.val);

    }



}
