package utils;

import java.util.Objects;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-27
 */
public class ListNode {
    /*
     * instance field
     */
    public int val;
    public ListNode next;

    /*
     * constructor
     */
    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    /*
     * methods
     */
    @Override
    public String toString() {
        return "{" + "val=" + val + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
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
