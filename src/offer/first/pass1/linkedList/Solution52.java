package offer.first.pass1.linkedList;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution52 {
    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点 - 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null? headB : curA.next;
            curB = curB == null? headA : curB.next;
        }

        return curA;
    }


    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点 - 短板效应
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int nA = getLinkedListLength(headA);
        int nB = getLinkedListLength(headB);
        int diffVal = nA > nB? nA - nB : nB - nA;
        ListNode curA = headA;
        ListNode curB = headB;
        if (diffVal > 0) {
            for (int i = 0; i < diffVal; i++) {
                curA = curA.next;
            }
        } else if (diffVal < 0) {
            for (int i = 0; i > diffVal; i--) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    /**
     * 获取链表长度
     * @param head
     * @return
     */
    private int getLinkedListLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }


    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点 - HashSet
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }
}
