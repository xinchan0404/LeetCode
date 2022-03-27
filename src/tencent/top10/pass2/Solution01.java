package tencent.top10.pass2;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * @author xinchan
 * @version 1.0.1 2022-03-27
 */
public class Solution01 {
    public void reorderList(ListNode head) {
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

class Solution01_ {
    public void reorderList(ListNode head) {
        ListNode middleNode = getMiddleNode(head);
        ListNode tail = reverseList(middleNode);
        mergeList(head, tail);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
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
            if (l1 == l2) {
                l2.next = null;
                break;
            }
            l2.next = l1;
            l2 = tmp2;
        }
    }
}
