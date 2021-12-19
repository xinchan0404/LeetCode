package dataStructure1_2.day08;

import utils.ListNode;
import utils.SingleLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 206. 反转链表
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @author xinchan
 * @version 1.0.1 2021-12-19
 */
public class ReverseList {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int[] array = {1, 2, 3, 4, 5};
        singleLinkedList.createSingleLinkedList(array);
        singleLinkedList.traversal();

        /*
         * 测试 reverseList()
         */
        ReverseList reverseList = new ReverseList();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000001; i++) {
//            singleLinkedList.head = reverseList.reverseList(singleLinkedList.head);  // 1000000: 32 ms
            singleLinkedList.head = reverseList.reverseList1(singleLinkedList.head);  // 1000000: 16 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        singleLinkedList.traversal();
    }

    /**
     * 反转单链表 - 堆栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Deque<ListNode> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode reverseHead = stack.pop();
        int size = stack.size();
        ListNode cur = reverseHead;
        for (int i = 0; i < size; i++) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;

        return reverseHead;
    }

    /**
     * 反转链表 - 原地反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }
}
