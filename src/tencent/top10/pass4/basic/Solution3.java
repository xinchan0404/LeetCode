package tencent.top10.pass4.basic;

import utils.ListNode;

/**
 * 141. 环形链表
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution3 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
