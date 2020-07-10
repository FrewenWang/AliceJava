package com.frewen.algorithm.demo.linklist;

/**
 * 给定一个链表，删除链表的倒数第 N 个节点，并且返回链表的头结点。
 * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：给定的 n 保证是有效的。要求：只允许对链表进行一次遍历。
 */


/**
 * 我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，
 * 而第二个指针将从列表的开头出发。现在，这两个指针被 nn 个结点分开。
 * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
 * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
 * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 */
public class RemoveNthFromEndTest {

    public static void main(String[] args) {

        ListNode<Integer> listNode = initListNode();

        int n = 3;

        listNode = removeNthFromEnd(listNode, n);

        listNodeTraverse(listNode);
    }

    private static void listNodeTraverse(ListNode listNode1) {
        while (null != listNode1) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }


    }

    private static ListNode<Integer> removeNthFromEnd(ListNode<Integer> listNode, int n) {
        // 重新实例化一个重试节点为0的数据
        ListNode dummy = new ListNode(0);
        // 作为传入的链表的头节点
        dummy.next = listNode;
        // 定义两个游标节点。
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first
        // and second is n nodes apart
        // 将第一个游标往前进行移动n个节点
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        // 将第一个游标节点和第二个游标节点保持同样的间距。移动到最后的位置
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 移除倒数第N个节点
        second.next = second.next.next;
        return dummy.next;
    }

    private static ListNode<Integer> initListNode() {
        ListNode listNode = new ListNode<>(1);
        listNode.next = new ListNode<>(2);
        listNode.next.next = new ListNode<>(3);
        listNode.next.next.next = new ListNode<>(4);
        listNode.next.next.next.next = new ListNode<>(5);

        return listNode;
    }
}
