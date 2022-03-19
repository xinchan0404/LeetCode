package offer.first.pass1.linkedList;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-13
 */
public class Solution25 {
    /**
     * 剑指 Offer 25. 合并两个排序的链表 - 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null? l2 : l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
        }

        return l1.val <= l2.val? l1 : l2;
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表 - 虚拟头、双指针
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null? l2 : l1;
        }

        ListNode virHead = new ListNode(-1);
        ListNode cur = virHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }

        cur.next = p1 == null? p2 : p1;

        return virHead.next;
    }
}
