package tencent.top10;

import utils.ListNode;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution10 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && n-- >= 0) {
            fast = fast.next;
        }
        if (fast == null && n == 0) {
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
