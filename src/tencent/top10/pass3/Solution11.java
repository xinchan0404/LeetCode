package tencent.top10.pass3;

import utils.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author xinchan
 * @version 1.0.1 2022-08-16
 */
public class Solution11 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (n == length) {
            return head.next;
        }
        cur = head;
        for (int i = 0; i < length - n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}

class Solution11_ {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        if (n >= 0) {
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
