package offerDay.first.pass2.day11;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution02 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private int cnt;
    private int k;
    private ListNode newHead;
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 递归
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        this.k = k;
        recur(head);
        return newHead;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        if (++cnt == k) {
            newHead = head;
        }
    }
}
