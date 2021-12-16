package offerLeetCode.utils;

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

    /*
     * methods
     */
    @Override
    public String toString() {
        return "{" + "val=" + val + '}';
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
