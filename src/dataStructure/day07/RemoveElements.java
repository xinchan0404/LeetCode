package dataStructure.day07;

import static dataStructure.day07.MergeTwoLists.traversal;

/**
 * 203. 移除链表元素
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author xinchan
 * @version 1.0.1 2021-12-05
 */
public class RemoveElements {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        int[] array = {1, 2, 6, 3, 4, 5, 6};
//        int[] array = {7, 7, 7, 7};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(array);
        ListNode head = singleLinkedList.getHead();

        /*
         * 测试 RemoveElements 方法
         */
        int val = 6;

        ListNode newHead = removeElements1(head, val);
        traversal(newHead);
    }

    /**
     * 移除链表中指定元素 - 遍历
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode tmp = head;
        ListNode pre = head;
        while (tmp != null) {
            if (tmp.val == val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }

        return head;
    }

    /**
     * 移除链表中的指定节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }
}
