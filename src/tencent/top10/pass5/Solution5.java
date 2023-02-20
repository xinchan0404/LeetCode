package tencent.top10.pass5;

import utils.ListNode;

/**
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
