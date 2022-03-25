package tencent.top10;

import utils.ListNode;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer II 026. 重排链表
 * @author xinchan
 * @version 1.0.1 2022-03-25
 */
public class Solution01 {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode tmp = head;
        while (tmp != null) {
            deque.offer(tmp);
            tmp = tmp.next;
        }
        ListNode cur = null;
        ListNode tail = null;
        while (!deque.isEmpty()) {
            if (tail != null) {
                tail.next = deque.peekFirst();
            }
            cur = deque.pollFirst();
            tail= deque.pollLast();
            if (!deque.isEmpty()) {
                deque.peekLast().next = null;
            }
            cur.next = tail;
        }
    }
}

class Solution01_ {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}

class Solution01__ {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode midNode = getMidNode(head);
        midNode.next = null;
        ListNode tail = reverseList(midNode);
        mergeList(head, tail);
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode tmp1;
        ListNode tmp2;
        while (l1 != null && l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l1 = tmp1;
            l2.next = l1;
            l2 = tmp2;
        }
    }
}
