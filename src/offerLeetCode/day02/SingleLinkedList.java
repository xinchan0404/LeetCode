package offerLeetCode.day02;

/**
 * 一个不带头节点的单链表
 *
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class SingleLinkedList {
    // instance field
    private ListNode head;  // 此处单链表头节点为数据节点，即已经存储数据

    // constructor
    public SingleLinkedList() {
    }

    // methods
    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

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

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        tmp.setNext(node);
        node.setNext(null);
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

        ListNode tmp = head;

        // 单链表只剩最后一个节点
        if (tmp.getNext() == null) {
            tmp = null;
            return;
        }

        while (tmp.getNext().getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(null);
    }

    public void show() {
        if (head == null) {
            System.out.println("链表为空，无法打印~~");
            return;
        }

        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.getNext();
        }
    }
}
