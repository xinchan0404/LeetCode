package codingInterviewDay_2.day12;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-03
 */
public class Solution01 {
    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode merge = new ListNode(-1);
        ListNode cur = merge;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (tmp1 != null || tmp2 != null) {
            if (tmp1 == null) {
                cur.next = tmp2;
                break;
            } else if (tmp2 == null) {
                cur.next = tmp1;
                break;
            } else if (tmp1.val < tmp2.val) {
                cur.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                cur.next = tmp2;
                tmp2 = tmp2.next;
            }
            cur = cur.next;
        }
        return merge.next;
    }
}
