package tencent.top10.pass3;

import utils.ListNode;

/**
 * 141. 环形链表
 * @author xinchan
 * @version 1.0.1 2022-08-02
 */
public class Solution03 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
