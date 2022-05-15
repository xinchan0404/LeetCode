package tencent.top50.pass2;

import utils.ListNode;

/**
 * 2. 两数相加
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + bit;
            bit = sum / 10;
            tail.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }
        if (bit == 1) {
            ListNode tmp = l1 == null ? l2 : l1;
            if (tmp == null) {
                tail.next = new ListNode(bit);
            } else {
                while (tmp != null) {
                    int sum = tmp.val + bit;
                    tail.next = new ListNode(sum % 10);
                    bit = sum / 10;
                    tail = tail.next;
                    tmp = tmp.next;
                }
                if (bit == 1) {
                    tail.next = new ListNode(1);
                }
            }
        } else {
            tail.next = l1 == null ? l2 : l1;
        }
        return head.next;
    }
}

class LC2_ {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int bit = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + bit;
            bit = sum / 10;
            tail.next = new ListNode(sum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            tail = tail.next;
        }
        if (bit == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}
