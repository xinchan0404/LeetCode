package offerLeetCode.day02;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class ListNode {
    // instance field
    private int value;
    private ListNode next;

    // constructor
    public ListNode() {

    }

    public ListNode(int value) {
        this.value = value;
    }

    // methods
    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + "value=" + value + '}';
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
