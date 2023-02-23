package tencent.top50.pass3;

import utils.ListNode;

/**
 * 21. 合并两个有序链表
 * @author xinchan
 * @version 1.0.1 2023-02-23
 */
public class Solution11 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode l1 = list1, l2 = list2, head = new ListNode(-1), cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
