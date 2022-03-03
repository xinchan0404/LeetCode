package codingInterviewDay_2.day11;

import codingInterviewDay_2.day10.Solution02;
import utils.ListNode;
import utils.SingleLinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 18. 删除链表的节点 - 前置指针
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode tmp = head;
        while (tmp.next != null && tmp.next.val != val) {
            tmp = tmp.next;
        }
        if (tmp.next != null) {
            tmp.next = tmp.next.next;
        }
        return head;
    }
}
