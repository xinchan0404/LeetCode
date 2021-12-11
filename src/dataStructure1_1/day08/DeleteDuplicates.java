package dataStructure1_1.day08;

import dataStructure1_1.utils.ListNode;
import dataStructure1_1.utils.SingleLinkedList;

/**
 * 83. 删除排序链表中的重复元素
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author xinchan
 * @version 1.0.1 2021-12-06
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
//        int[] array = {};
        int[] array = {1};
//        int[] array = {1, 1, 2};
//        int[] array = {1,1,2,3,3};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(array);
        ListNode head = singleLinkedList.head;

        /*
         * 测试 deleteDuplicates 方法
         */
        ListNode newHead = deleteDuplicates(head);
        SingleLinkedList.traversal(newHead);
    }

    /**
     * 删除排序链表中的重复元素 - 遍历
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        int val = head.val;
        ListNode tmp = head.next;
        ListNode pre = head;
        while (tmp != null) {
            if (tmp.val == val) {
                pre.next = tmp.next;
            } else {
                val = tmp.val;
                pre = tmp;
            }
            tmp = tmp.next;
        }

        return head;
    }
}
