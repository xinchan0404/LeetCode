package tencent.top10.pass1;

import utils.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * @author xinchan
 * @version 1.0.1 2022-03-26
 */
public class Solution08 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>();
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            tail = tail.next;
        }
        return head.next;
    }
}
