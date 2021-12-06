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
public class SingleLinkedList {
    /*
     * instance field
     */
    private ListNode head;

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
     * 创建单链表
     * @param array
     */
    public void createSingleLinkedList(int[] array) {
        if (head == null) {
            head = new ListNode(array[0]);
        }

        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            tmp.next = node;
            tmp = tmp.next;
        }
    }
}
