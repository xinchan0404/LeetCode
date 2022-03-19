package offer.first.pass1.linkedList;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-13
 */
public class Again {
    private ListNode newHead;
    /**
     * 剑指 Offer 24. 反转链表 - 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        reversedListRecur(head);;
        return newHead;
    }

    /**
     * 剑指 Offer 24. 反转链表 - 递归
     * @param head
     */
    private void reversedListRecur(ListNode head) {
        if (head == null || head.next == null) {
            newHead = head;
            return;
        }

        reversedListRecur(head.next);
        head.next.next = head;
        head.next = null;
    }


    private int cnt;
    private ListNode ans;
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 递归
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        getKthFromEndRecur(head, k);

        return ans;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点 - 递归
     * @param head
     * @param k
     */
    private void getKthFromEndRecur(ListNode head, int k) {
        if (head == null) {
            return;
        }

        getKthFromEnd(head.next, k);
        if (cnt + 1 == k) {
            ans = head;
        } else {
            cnt++;
        }
    }


    /**
     * 剑指 Offer 18. 删除链表的节点 - 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val != val) {
            head.next = deleteNode(head.next, val);
        } else {
            return head.next;
        }

        return head;
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        reversePrintRecur(head, list);

        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表 - 递归
     * @param head
     * @param list
     */
    private void reversePrintRecur(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }

        reversePrintRecur(head.next, list);
        list.add(head.val);
    }
}
