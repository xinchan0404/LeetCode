package crackingTheCodingInterview.ch02;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution04 {
    /**
     * 面试题 02.04. 分割链表 - 虚拟头节点、拼接链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode curS = small;
        ListNode curL = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                curS.next = cur;
                curS = curS.next;
            } else {
                curL.next = cur;
                curL = curL.next;
            }
            cur = cur.next;
        }
        curL.next = null;
        curS.next = large.next;
        return small.next;
    }


    /**
     * 面试题 02.04. 分割链表 - 虚拟头节点、修改指针
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        boolean flag = false;
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;
        ListNode cur = virtualHead;
        ListNode node;
        while (cur.next != null) {
            if (!flag) {
                if (cur.next.val >= x) {
                    flag = true;
                }
                cur = cur.next;
            } else if (cur.next.val < x) {
                node = cur.next;
                cur.next = cur.next.next;
                node.next = virtualHead.next;
                virtualHead.next = node;
            } else {
                cur = cur.next;
            }
        }

        return virtualHead.next;
    }
}
