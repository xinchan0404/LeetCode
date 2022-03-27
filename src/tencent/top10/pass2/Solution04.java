package tencent.top10.pass2;

import utils.ListNode;

/**
 * 206. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-03-27
 */
public class Solution04 {
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

        reverseList(head.next);
        head.next.next = head;
        head.next = null;
    }
}
