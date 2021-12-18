package utils;

/**
 * 循环链表，链表尾指针指向某个节点
 * @author xinchan
 * @version 1.0.1 2021-12-18
 */
public class CycleLinkedList {
    /*
     * instance field
     */
    public ListNode head;
    public ListNode cycleNode;
    public ListNode lastNode;

    /*
     * constructor
     */
    public CycleLinkedList() {
        this.head = null;
        this.cycleNode = null;
    }

    /**
     * 根据传入的数组以及指定的位置创建环形链表
     * @param array
     * @param pos 指定的循环位置，-1 表示没有循环
     */
    public void createCycleLinkedList(int[] array, int pos) {
        ListNode node = new ListNode(array[0]);
        head = node;
        if (pos == 0) {
            cycleNode = node;
        }

        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            node = new ListNode(array[i]);
            if (i == pos) {
                cycleNode = node;
            }
            cur.next = node;
            cur = cur.next;
        }
        lastNode = cur;
        cur.next = cycleNode;
    }

    /**
     * 遍历循环链表
     */
    public void traversal() {
        if (head == null) {
            System.out.println("链表为空，无法遍历~~");
            return;
        }

        ListNode cur = head;
        while (cur.next != null) {
            System.out.print(cur + "==>");
            cur = cur.next;
            if (cur == lastNode) {
                break;
            }
        }
        System.out.print(cur);
        if (cur.next != null) {
            System.out.print("==>" + cur.next + "......");
        }
    }
}
