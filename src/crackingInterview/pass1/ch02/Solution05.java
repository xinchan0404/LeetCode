package crackingInterview.pass1.ch02;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-14
 */
public class Solution05 {
    /**
     * 面试题 02.05. 链表求和 - 双指针、缺位单独处理
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode l = new ListNode(-1);
        ListNode curSum = l;
        int tens = 0;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + tens;
            tens = sum / 10;
            curSum.next = new ListNode(sum % 10);
            curSum = curSum.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if (cur1 == null && cur2 == null) {
            if (tens == 1) {
                curSum.next = new ListNode(1);
            }
        } else {
            ListNode remaining = cur1 == null ? cur2 : cur1;
            while (remaining != null) {
                if (tens == 1) {
                    tens = (remaining.val + 1) / 10;
                    curSum.next = new ListNode((remaining.val + 1) % 10);
                    remaining = remaining.next;
                    curSum = curSum.next;
                } else {
                    curSum.next = remaining;
                    break;
                }
            }
        }
        if (tens == 1) {
            curSum.next = new ListNode(1);
        }

        return l.next;
    }


    /**
     * 面试题 02.05. 链表求和 - 双指针、缺位补 0
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode l = new ListNode(-1);
        ListNode curSum = l;
        int tens = 0;
        while (cur1 != null || cur2 != null) {
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            int sum = val1 + val2 + tens;
            tens = sum / 10;
            curSum.next = new ListNode(sum % 10);
            curSum = curSum.next;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }

        if (tens == 1) {
            curSum.next = new ListNode(1);
        }

        return l.next;
    }

    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 7, 9, 9, 9, 9};
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList1.createSingleLinkedList(arr1);
        singleLinkedList2.createSingleLinkedList(arr2);
        singleLinkedList1.traversal();
        singleLinkedList2.traversal();

        /*
         * 测试 addTwoNumbers()
         */
        Solution05 solution05 = new Solution05();
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            singleLinkedList.head = solution05.addTwoNumbers(singleLinkedList1.head, singleLinkedList2.head);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        singleLinkedList.traversal();
    }
}
