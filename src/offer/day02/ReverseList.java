package offer.day02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 24. 反转链表
 * 限制：
 * 1. 0 <= 节点个数 <= 5000
 *
 * @author xinchan
 * @version 1.0.1 2021-11-28
 */
public class ReverseList {
    public static void main(String[] args) {
        /*
         * 创建单链表并插入节点
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(new ListNode(1));
        singleLinkedList.add(new ListNode(2));
        singleLinkedList.add(new ListNode(3));
        singleLinkedList.add(new ListNode(4));
        singleLinkedList.add(new ListNode(5));

        ListNode head = singleLinkedList.getHead();

        /*
         * 测试 reverseList()
         */
        SingleLinkedList newSingleLinedList = new SingleLinkedList();

//        ListNode newHead = reverseList(head);
        ListNode newHead = reverseList1(head);  // 原地反转

        newSingleLinedList.setHead(newHead);
        newSingleLinedList.show();
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

        ListNode tmp = head;
        Deque<ListNode> stack = new LinkedList<>();
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.getNext();
        }

        ListNode newHead = stack.pop();
        ListNode tmpHead = newHead;
        while (!stack.isEmpty()) {
            ListNode addNode = stack.pop();
            tmpHead.setNext(addNode);
            addNode.setNext(null);
            tmpHead = tmpHead.getNext();
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

        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
