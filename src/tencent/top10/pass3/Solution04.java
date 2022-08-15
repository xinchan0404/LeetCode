package tencent.top10.pass3;

import utils.ListNode;

/**
 * 142. 环形链表 II
 * @author xinchan
 * @version 1.0.1 2022-08-02
 */
public class Solution04 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 先找快慢指针相遇节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 再找环形链表的入口节点
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
