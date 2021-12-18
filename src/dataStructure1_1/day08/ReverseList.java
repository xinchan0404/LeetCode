package dataStructure1_1.day08;

import utils.ListNode;
import utils.SingleLinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-05
 */
public class ReverseList {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        int[] array = {1, 2, 3, 4, 5};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(array);
        ListNode head = singleLinkedList.head;

        /*
         * 测试 reverseList 方法
         */
        singleLinkedList.head = reverseList1(head);
        singleLinkedList.traversal();
    }

    /**
     * 反转单链表 - 堆栈
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Deque<ListNode> stack = new LinkedList<>();

        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        ListNode newHead = stack.pop();
        tmp = newHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            tmp.next = node;
            node.next = null;
            tmp = tmp.next;
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
        ListNode cur = head;
        ListNode post;
        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }
}
