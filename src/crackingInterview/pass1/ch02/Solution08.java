package crackingInterview.pass1.ch02;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution08 {
    /**
     * 面试题 02.08. 环路检测 - 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    /**
     * 面试题 02.08. 环路检测 - HashSet
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.add(cur)) {
                cur = cur.next;
            } else {
                return cur;
            }
        }
        return null;
    }
}
