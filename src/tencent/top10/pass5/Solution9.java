package tencent.top10.pass5;

import utils.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-20
 */
public class Solution9 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        ListNode head = new ListNode(-1), cur = head;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode tail = queue.poll();
            cur.next = tail;
            cur = cur.next;

            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }

        return head.next;
    }
}
