package codingInterviewDay_2.day12;

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
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            if (tmp1 == null && tmp2 == null) {
                break;
            }
            if (tmp1 == null) {
                tmp1 = headB;
            }
            if (tmp2 == null) {
                tmp2 = headA;
            }
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
            tmp = tmp.next;
            diff++;
        }
        tmp = headB;
        while (tmp != null) {
            tmp = tmp.next;
            diff--;
        }

        ListNode tmp1 = null;
        if (diff > 0) {
            tmp = headA;
            tmp1 = headB;
            while (diff > 0) {
                tmp = tmp.next;
                diff--;
            }
        } else if (diff < 0) {
            tmp = headB;
            tmp1 = headA;
            while (diff < 0) {
                tmp = tmp.next;
                diff++;
            }
        }

        while (tmp != tmp1) {
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }

        return tmp;
    }
}
