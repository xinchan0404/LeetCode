package tencent.top10.pass4.basic;

import utils.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution8 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode(0), cur = head;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head.next;
    }
}
