package tencent.top50;

import utils.ListNode;

/**
 * 160. 相交链表
 * @author xinchan
 * @version 1.0.1 2022-04-04
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
