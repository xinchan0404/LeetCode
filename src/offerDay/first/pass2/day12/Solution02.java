package offerDay.first.pass2.day12;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution02 {
    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点 - 快慢指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (tmp1 != tmp2) {
            tmp1 = tmp1 == null ? headB : tmp1.next;
            tmp2 = tmp2 == null ? headA : tmp2.next;
        }
        return tmp1;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点 - 短板效应
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int diff = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            diff++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            diff--;
            tmp = tmp.next;
        }
        tmp = diff > 0 ? headA : headB;
        for (int i = 0; i < Math.abs(diff); i++) {
            tmp = tmp.next;
        }
        ListNode tmp1 = diff > 0 ? headB : headA;
        while (tmp != tmp1) {
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }
        return tmp;
    }
}
