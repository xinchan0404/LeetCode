package codingInterviewDay_2.day11;

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
        if (k <= 0) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
