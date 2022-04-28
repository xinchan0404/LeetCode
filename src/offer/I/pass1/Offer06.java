package offer.I.pass1;

import utils.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * @author xinchan
 * @version 1.0.1 2022-04-28
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        int[] ans = new int[size];
        tmp = head;
        for (int i = 0; i < size; i++) {
            ans[size - i - 1] = tmp.val;
            tmp = tmp.next;
        }
        return ans;
    }
}
