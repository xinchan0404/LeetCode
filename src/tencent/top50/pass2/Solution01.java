package tencent.top50.pass2;

import utils.ListNode;

/**
 * 2. 两数相加
 * @author xinchan
 * @version 1.0.1 2022-08-16
 */
public class Solution01 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode tmp1 = l1, tmp2 = l2;
        int bit = 0;
        while (tmp1 != null || tmp2 != null) {
            int num1 = tmp1 != null ? tmp1.val : 0;
            int num2 = tmp2 != null ? tmp2.val : 0;
            int sum = num1 + num2 + bit;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            bit = sum / 10;
            tmp1 = tmp1 != null ? tmp1.next : null;
            tmp2 = tmp2 != null ? tmp2.next : null;
        }
        if (bit == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
