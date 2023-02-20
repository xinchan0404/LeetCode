package tencent.top10.pass5;

import utils.ListNode;

/**
 * 142. 环形链表 II
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution4 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
