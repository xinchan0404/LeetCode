package tencent.top10.pass1;

import utils.ListNode;

/**
 * 剑指 Offer II 024. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution04 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}

class Solution04_ {
    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        recur(head);
        return newHead;
    }

    private void recur(ListNode head) {
        if (head == null || head.next == null) {
            newHead = head;
            return;
        }

        recur(head.next);
        head.next.next = head;
        head.next = null;
    }
}

class Solution04__ {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
