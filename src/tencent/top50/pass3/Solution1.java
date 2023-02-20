package tencent.top50.pass3;

import utils.ListNode;

/**
 * 2. 两数相加
 * @author xinchan
 * @version 1.0.1 2023-02-21
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bit = 0, add = 0, tmp;
        ListNode ll1 = l1, ll2 = l2, head = new ListNode(-1), cur = head;
        while (ll1 != null || ll2 != null) {
            int n1 = ll1 == null ? 0 : ll1.val;
            int n2 = ll2 == null ? 0 : ll2.val;
            tmp = n1 + n2 + add;
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            add = tmp / 10;
            ll1 = ll1 == null ? null : ll1.next;
            ll2 = ll2 == null ? null : ll2.next;
        }
        if (add == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
