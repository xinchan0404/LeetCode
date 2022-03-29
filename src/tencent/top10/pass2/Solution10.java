package tencent.top10.pass2;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-29
 */
public class Solution10 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
