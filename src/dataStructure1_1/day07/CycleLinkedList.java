package dataStructure1_1.day07;

import utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-02
 */
public class CycleLinkedList {
    /*
     * instance field
     */
    public ListNode head;

    /*
     * constructor
     */
    public CycleLinkedList() {
    }

    /*
     * methods
     */
    /**
     * 创建环形链表
     *
     * @param array
     * @param pos
     */
    public void createCycleLinkedList(int[] array, int pos) {
        if (head == null) {
            head = new ListNode(array[0]);
        }

        ListNode tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        ListNode nodeCycle = null;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            if (i == pos) {
                nodeCycle = node;
            } else if (pos == 0) {
                nodeCycle = head;
            }
            tmp.next = node;
            tmp = tmp.next;
        }

        if (pos != -1) {
            tmp.next = nodeCycle;
        }
    }
}
