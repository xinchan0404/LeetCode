package crackingTheCodingInterview.ch02;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution07 {
    /**
     * 面试题 02.07. 链表相交 - 快慢指针
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
            if (curA.next == null && curB.next == null) {
                return null;
            }
            curA = curA.next != null? curA.next : curB;
            curB = curB.next != null? curB.next : curA;
        }

        return curA;
    }


    /**
     * 面试题 02.07. 链表相交 - 短板效应
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int m = 0;
        int n = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            m++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        if (m > n) {
            for (int i = 0; i < m - n; i++) {
                curA = curA.next;
            }
        } else if (m < n) {
            for (int i = 0; i < n - m; i++) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curB.next;
            curB = curB.next;
        }

        return null;
    }


    /**
     * 面试题 02.07. 链表相交 - 递归
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
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
