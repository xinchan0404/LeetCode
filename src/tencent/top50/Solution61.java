package tencent.top50;

import utils.ListNode;

/**
 * 61. 旋转链表
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        ListNode tail = null;
        while (tmp != null) {
            if (tmp.next == null) {
                tail = tmp;
            }
            tmp = tmp.next;
            length++;
        }
        if ((k = k % length) == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = slow.next;
        slow.next = null;
        tail.next = head;
        return newHead.next;
    }
}
