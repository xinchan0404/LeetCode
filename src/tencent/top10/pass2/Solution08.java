package tencent.top10.pass2;

import utils.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * @author xinchan
 * @version 1.0.1 2022-03-28
 */
public class Solution08 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
            tail = tail.next;
        }
        return head.next;
    }
}
