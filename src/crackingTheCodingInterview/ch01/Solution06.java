package crackingTheCodingInterview.ch01;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution06 {
    /**
     * 面试题 02.06. 回文链表 - 快慢指针、部分反转链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        /*
         * 反转后半部分链表
         */
        int start = n % 2 == 0? n / 2 : n / 2 + 1;
        ListNode tmp = head;
        for (int i = 0; i < start; i++) {
            tmp = tmp.next;
        }
        ListNode pre = tmp;
        cur = pre.next;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        ListNode left = head;
        ListNode right = pre;
        for (int i = 0; i < n / 2; i++) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        /*
         * 还原后半部分被反转的链表
         */
        cur = pre;
        pre = cur.next;
        while (cur != tmp) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return true;
    }


    /**
     * 面试题 02.06. 回文链表 - 对称遍历
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        ListNode right = head;
        int start = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 0; i < start; i++) {
            right = right.next;
        }

        int index = n % 2 == 0? 1 : 2;
        while (right != null) {
            ListNode left = head;
            for (int i = 0; i < start - index; i++) {
                left = left.next;
            }
            if (left.val != right.val) {
                return false;
            }
            right = right.next;
            index++;
        }

        return true;
    }
}
