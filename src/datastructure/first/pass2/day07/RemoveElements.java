package datastructure.first.pass2.day07;

import utils.ListNode;
import utils.SingleLinkedList;

/**
 * 203. 移除链表元素
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author xinchan
 * @version 1.0.1 2021-12-18
 */
public class RemoveElements {
    public static void main(String[] args) {
        /*
         * 创建单链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int[] array = {1, 2, 6, 3, 4, 5, 6};
//        int[] array = {6, 6, 6, 6};
        singleLinkedList.createSingleLinkedList(array);
        singleLinkedList.traversal();

        /*
         * 测试 removeElements()
         */
        RemoveElements removeElements = new RemoveElements();
        int val = 6;
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            singleLinkedList1.head = removeElements.removeElements(singleLinkedList.head, val);  // 1000000: 16 ms
        }
        long costMs = System.currentTimeMillis() - startMs;
        System.out.println("耗时：" + costMs + " ms");
        singleLinkedList1.traversal();
    }

    /**
     * 移除链表中的指定元素 - 辅助头节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode assistHead = new ListNode(-1);
        assistHead.next = head;
        ListNode cur = assistHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return assistHead.next;
    }
}
