package offerDay.I.pass1.day02;

import utils.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-￥06-23
 */
public class Solution02 {
    /**
     * 原地反转
     */
    public ListNode reverseList(ListNode head) {
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
    /**
     * 递归
     */
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
