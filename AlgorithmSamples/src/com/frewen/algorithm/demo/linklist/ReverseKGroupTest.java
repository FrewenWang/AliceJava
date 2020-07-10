package com.frewen.algorithm.demo.linklist;

public class ReverseKGroupTest {

    public static void main(String[] args) {
        ListNode listNode = ListNode.initListNode();
        reverseKGroup(listNode, 3);
    }


    /**
     * 将当前链表以k个为一组进行反转
     *
     * @param head
     * @param k
     */
    private static ListNode reverseKGroup(ListNode head, int k) {
        // 获取到链表的头节点
        ListNode temp = head;
        // 找到一组的为节点
        for (int i = 1; i < k && temp != null; i++) {
            // 设置temp的为下一个节点
            temp = temp.next;
        }

        //判断节点的数量是否能够凑成一组
        if (temp == null) {
            return head;
        }

        // 计算第二个节点
        ListNode t2 = temp.next;
        temp.next = null;

        return null;
    }
}
