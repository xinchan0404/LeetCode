package dataStructure.day07;

/**
 * 21. 合并两个有序链表
 * 提示：
 * 1. 两个链表的节点数目范围是 [0, 50]
 * 2. -100 <= Node.val <= 100
 * 3. l1 和 l2 均按 非递减顺序 排列
 *
 * @author xinchan
 * @version 1.0.1 2021-12-04
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList1.createSingleLinkedList(array1);
        singleLinkedList2.createSingleLinkedList(array2);

        ListNode list1 = singleLinkedList1.getHead();
        ListNode list2 = singleLinkedList2.getHead();

        /*
         * 测试 mergeTwoLists 方法
         */
        ListNode newHead = mergeTwoLists1(list1, list2);

        traversal(newHead);
    }

    /**
     * 合并两个有序链表 - 双指针、遍历
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }

        pre.next = list1 == null ? list2 : list1;

        return head.next;
    }

    /**
     * 遍历单链表
     *
     * @param head 单链表头节点
     */
    public static void traversal(ListNode head) {
        if (head == null) {
            System.out.println("链表为空，无法遍历~~");
            return;
        }

        ListNode tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp + "--");
            tmp = tmp.next;
        }
        System.out.println(tmp);
    }

    /**
     * 合并两个有序链表 - 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
