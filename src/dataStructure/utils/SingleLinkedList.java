package dataStructure.utils;

import dataStructure.utils.ListNode;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-05
 */
public class SingleLinkedList {
    /*
     * instance field
     */
    ListNode head;

    /*
     * constructor
     */
    public SingleLinkedList() {

    }

    /*
     * methods
     */
    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    /**
     * 创建基于数组数据的单链表
     *
     * @param array
     */
    public void createSingleLinkedList(int[] array) {
        head = new ListNode(array[0]);

        ListNode tmp = head;
        for (int i = 1; i < array.length; i++) {
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
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
}
