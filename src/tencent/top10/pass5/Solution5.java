package tencent.top10.pass5;

import utils.ListNode;

/**
 * 206. 反转链表
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution5 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, post;

        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}

class Solution5_1 {
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
