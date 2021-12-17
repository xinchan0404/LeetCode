package codingInterviewLeetCode.utils;

/**
 * 一个不带头节点的单链表
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class SingleLinkedList {
    /*
     * instance field
     */
    public ListNode head;  // 此处单链表头节点为数据节点，即已经存储数据

    /*
     * constructor
     */
    public SingleLinkedList() {
    }

    /*
     * methods
     */

    /**
     * 添加新节点
     *
     * @param node
     */
    public void add(ListNode node) {
        if (head == null) {
            head = node;
            return;
        }

        ListNode tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
        node.next = null;
    }

    /**
     * 根据传入的数组创建带头结点的单链表
     *
     * @param array
     */
    public void createSingleLInkedList(int[] array) {
        head = new ListNode(array[0]);

        ListNode tmp = head;
        for (int i = 1; i < array.length; i++) {
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
    }

    /**
     * 删除最后一个节点节点
     * 由于是不带头节点的单链表，因此要考虑待删除的节点是不是第一个节点
     *
     * @return
     */
    public void remove() {
        if (head == null) {
            System.out.println("链表为空，无法删除~~");
            return;
        }

        // 单链表只剩最后一个节点
        if (head.next == null) {
            head = null;
            return;
        }

        ListNode tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
    }

    /**
     * 遍历当前链表
     */
    public void traversal() {
        if (head == null) {
            System.out.println("链表为空，无法打印~~");
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
