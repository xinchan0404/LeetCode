package tencent.top50;

import utils.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * @author xinchan
 * @version 1.0.1 2022-04-18
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
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
