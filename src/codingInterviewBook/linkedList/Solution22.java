package codingInterviewBook.linkedList;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution22 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 顺序查找
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;
        for (int i = 0; i < n - k; i++) {
            cur = cur.next;
        }

        return cur;
    }

    private ListNode ans;
    private int cnt;

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        getKthFromEndRecur(head, k);

        return ans;
    }

    /**
     * 递归方法
     *
     * @param head
     * @param k
     */
    private void getKthFromEndRecur(ListNode head, int k) {
        if (head == null) {
            return;
        }

        getKthFromEndRecur(head.next, k);
        if (cnt + 1 == k) {
            ans = head;
        }
        cnt++;
    }
}
