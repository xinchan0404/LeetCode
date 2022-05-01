package offerDay.I.pass3.day02;

import utils.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-04-30
 */
public class Solution02 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}

class Solution02_ {
    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        recursion(head);
        return newHead;
    }

    public void recursion(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return;
        }
        recursion(head.next);
        head.next.next = head;
        head.next = null;
    }
}
