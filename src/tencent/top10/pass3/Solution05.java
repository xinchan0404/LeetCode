package tencent.top10.pass3;

import utils.ListNode;

/**
 * 206. 反转链表
 * @author xinchan
 * @version 1.0.1 2022-08-03
 */
public class Solution05 {
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

class Solution05_ {
    private ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        recur(head);
        return newHead;
    }

    private void recur(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return;
        }
        recur(head.next);
        head.next.next = head;
        head.next = null;
    }
}
