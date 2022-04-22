package tencent.top50.pass1;

import utils.ListNode;

/**
 * 2. 两数相加
 * @author xinchan
 * @version 1.0.1 2022-03-30
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            sum = n1 + n2 + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}
