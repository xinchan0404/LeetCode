package tencent.top10.pass5;

import utils.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution11 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        int len = 0;

        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == n) {
            return head.next;
        }

        cur = head;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }
}
class Solution11_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null && n >= 0) {
            cur = cur.next;
            n--;
        }

        if (n == 0) {
            return head.next;
        }

        ListNode slow = head;
        ListNode fast = cur;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
