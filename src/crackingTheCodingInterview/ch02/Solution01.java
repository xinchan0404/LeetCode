package crackingTheCodingInterview.ch02;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution01 {
    /**
     * 面试题 02.01. 移除重复节点 - 双重循环、时间换空间
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null) {
            ListNode cur1 = cur;
            while (cur1.next != null) {
                if (cur1.next.val == cur.val) {
                    cur1.next = cur1.next.next;
                } else {
                    cur1 = cur1.next;
                }
            }
            cur = cur.next;
        }

        return head;
    }


    /**
     * 面试题 02.01. 移除重复节点 - HashSet、pre 指针
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            if (set.add(cur.next.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }

        return head;
    }
}
