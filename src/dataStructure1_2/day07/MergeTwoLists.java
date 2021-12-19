package dataStructure1_2.day07;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * 21. 合并两个有序链表
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * @author xinchan
 * @version 1.0.1 2021-12-18
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};
        list1.createSingleLinkedList(array1);
        list2.createSingleLinkedList(array2);
        list1.traversal();
        list2.traversal();

        /*
         * 测试 mergeTwoLists()
         */
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode head = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            head = mergeTwoLists.mergeTwoLists(list1.head, list2.head);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.head = head;
        singleLinkedList.traversal();
    }

    /**
     * 合并两个有序的链表 - 双指针法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);  // 带头节点的单链表操作还是方便一些
        ListNode cur = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                break;
            } else if (cur2 == null) {
                cur.next = cur1;
                break;
            } else if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        return head.next;
    }

    /**
     * 合并两个有序的链表 - 递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        return null;
    }
}
