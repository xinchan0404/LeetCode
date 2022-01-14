package codingInterview.linkedList;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution18 {
    /**
     * 剑指 Offer 18. 删除链表的节点 - 维护 pre 指针
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            ListNode virHead = head.next;
            head.next = null;
            return virHead;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点 - 无需维护 pre 指针
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }

        return head;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点 - 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val != val) {
            head.next = deleteNode(head.next, val);
        } else {
            return head.next;
        }

        return head;
    }
}
