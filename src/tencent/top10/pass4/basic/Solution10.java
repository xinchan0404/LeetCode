package tencent.top10.pass4.basic;

import utils.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author xinchan
 * @version 1.0.1 2023-02-19
 */
public class Solution10 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (n == len) {
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
