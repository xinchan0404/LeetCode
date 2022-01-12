package codingInterviewBook.linkedList;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-12
 */
public class Solution24 {
    /**
     * 剑指 Offer 24. 反转链表 - 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * 剑指 Offer 24. 反转链表 - 修改指针、pre 指针、cur 指针
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            cur = post;
            pre = cur;
        }

        return pre;
    }

    /**
     * 剑指 Offer 24. 反转链表 - 栈
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode newHead = stack.pop();
        cur = newHead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;

        return newHead;
    }
}
