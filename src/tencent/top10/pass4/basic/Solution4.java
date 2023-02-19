package tencent.top10.pass4.basic;

import utils.ListNode;

/**
 * 206. 反转链表
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution4 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, post = null;
        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}
