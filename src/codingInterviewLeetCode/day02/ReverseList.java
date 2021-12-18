package codingInterviewLeetCode.day02;

import utils.ListNode;
import utils.SingleLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 24. 反转链表
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-17
 */
public class ReverseList {
    public static void main(String[] args) {
        /*
         * 创建单链表并插入节点
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int[] array = {1, 2, 3, 4, 5};
        singleLinkedList.createSingleLinkedList(array);
        singleLinkedList.traversal();
        ListNode head = singleLinkedList.head;

        /*
         * 测试 reverseList()
         */
        ReverseList reverseList = new ReverseList();
        ListNode newHead = null;

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            newHead = reverseList.reverseList(head);  // 1000000 次：42 ms
//            newHead = reverseList.reverseList1(head);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.head = newHead;
        System.out.print("原链表：");
        singleLinkedList.traversal();
        System.out.print("反转后链表：");
        singleLinkedList1.traversal();
    }

    /**
     * 反转单链表 - 堆栈，不改动原链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        int counter = 0;
        while (cur != null) {
            counter++;
            cur = cur.next;
        }

        int[] stack = new int[counter];
        cur = head;
        for (int i = counter - 1; i >= 0; i--) {
            stack[i] = cur.val;
            cur = cur.next;
        }

        ListNode newHead = new ListNode(stack[0]);
        cur = newHead;
        for (int i = 1; i < counter; i++) {
            cur.next = new ListNode(stack[i]);
            cur = cur.next;
        }

        return newHead;
    }

    /**
     * 反转链表 - 原地反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;

        while (head != null) {
            ListNode post = head.next;
            head.next = pre;  // 反转正向链接
            pre = head;
            head = post;
        }

        return pre;
    }
}
