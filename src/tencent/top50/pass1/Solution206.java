package tencent.top50.pass1;

import utils.ListNode;

/**
 * 206. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution206 {
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

class Solution206_ {
    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        recur(head);
        return newHead;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            newHead = head;
            return;
        }

        recur(head.next);
        head.next.next = head;
        head.next = null;
    }
}
