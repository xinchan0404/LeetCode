package leetCode;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * 86. 分隔链表
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @author xinchan
 * @version 1.0.1 2021-12-17
 */
public class Partition {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
//        int[] array = {1, 4, 3, 2, 5, 2};
//        int x = 3;
//        int[] array = {3, 2, 1};
//        int x = 1;
        int[] array = {1, 2, 3, 4, 5};
        int x = 6;
//        int[] array = {1, 4, 3, 0, 2, 5, 2};
//        int x = 3;
//        int[] array = {4, 3, 2, 5, 2};
//        int x = 3;
//        int[] array = {2, 0, 4, 1, 3, 1, 4, 0, 3};
//        int x = 4;
//        int[] array = {5,4,3,2,1};
//        int x = 3;
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(array);
        singleLinkedList.traversal();
        ListNode head = singleLinkedList.head;

        /*
         * 测试 partition()
         */
        Partition partition = new Partition();
        ListNode newHead = null;
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            newHead = partition.partition1(head, x);
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");

        singleLinkedList.head = newHead;
        singleLinkedList.traversal();
    }

    /**
     * 分隔链表 - 原地修改
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode curInsert = head;
        ListNode pre = null;
        boolean flag = false;
        while (cur != null) {
            if (!flag && cur.val >= x) {
                flag = true;
                if (pre != null) {
                    curInsert = pre;
                }
                pre = cur;
                cur = cur.next;
                continue;
            }
            if (flag && cur.val < x) {
                ListNode node = cur;
                pre.next = cur.next;
                cur = cur.next;
                if (curInsert.val >= x) {
                    node.next = curInsert;
                    head = node;
                    curInsert = head;
                } else {
                    node.next = curInsert.next;
                    curInsert.next = node;
                    curInsert = curInsert.next;
                }
                continue;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    /**
     * 分隔链表 - 维护两个链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode largeHead = null;
        ListNode curSmall = null;
        ListNode curLarge = null;
        while (head != null) {
            if (head.val < x) {
                if (smallHead == null) {
                    smallHead = head;
                    curSmall = smallHead;
                } else {
                    curSmall.next = head;
                    curSmall = curSmall.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = head;
                    curLarge = largeHead;
                } else {
                    curLarge.next = head;
                    curLarge = curLarge.next;
                }
            }
            head = head.next;
        }

        if (smallHead != null) {
            curSmall.next = largeHead;
            if (largeHead != null) {
                curLarge.next = null;
            }
            return smallHead;
        }

        return largeHead;
    }
}
