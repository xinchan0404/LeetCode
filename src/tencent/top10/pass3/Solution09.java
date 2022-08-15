package tencent.top10.pass3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xinchan
 * @version 1.0.1 2022-08-15
 */
public class Solution09 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode cur = head;
        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode top = priorityQueue.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) {
                priorityQueue.offer(top.next);
            }
        }

        return head.next;
    }
}
