package datastructure.first.pass2.day08;

import utils.ListNode;
import utils.SingleLinkedList;

import java.util.*;

/**
 * 83. 删除排序链表中的重复元素
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author xinchan
 * @version 1.0.1 2021-12-19
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int[] array = {1,1,2,3,3};
        singleLinkedList.createSingleLinkedList(array);
        singleLinkedList.traversal();

        /*
         * 测试 deleteDuplicates()
         */
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000001; i++) {
//            singleLinkedList.head = deleteDuplicates.deleteDuplicates(singleLinkedList.head);  // 1000000: 31 ms
            singleLinkedList.head = deleteDuplicates.deleteDuplicates1(singleLinkedList.head);  // 1000000: 0 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        singleLinkedList.traversal();
    }

    /**
     * 删除排序链表中的重复元素 - HashSet，需要重写 ListNode 的 equals()
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();

        while (head != null) {
            if (!deque.contains(head)) {
                deque.add(head);
            }
            head = head.next;
        }

        ListNode newHead = deque.remove();
        int size = deque.size();
        ListNode cur = newHead;
        for (int i = 0; i < size; i++) {
            cur.next = deque.remove();
            cur = cur.next;
        }
        cur.next = null;

        return newHead;
    }

    /**
     * 删除排序链表中的重复元素 - 遍历、双指针法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        int val = pre.val;

        while (cur != null) {
            if (cur.val != val) {
                val = cur.val;
                pre = cur;
            } else {
                pre.next = pre.next.next;
            }
            cur = cur.next;
        }

        return head;
    }
}
