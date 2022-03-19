package offerDay.first.pass2.day02;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution02 {
    private ListNode newHead;
    /**
     * 剑指 Offer 24. 反转链表 - 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        reverseListRecur(head);
        return newHead;
    }

    public void reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            newHead = head;
            return;
        }

        reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
    }
}
