package com.frewen.algorithm.demo.linklist;
public class L19RemoveNthNodeFromEndOfList {


    public static void main(String[] args) {
        int n = 2;
        ListNode head = ListNode.initListNode();
        removeNthEndNodeOfList(head, n);
    }

    private static ListNode removeNthEndNodeOfList(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = slow.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;
        return head;
    }
}
