package dataStructure.utils;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-05
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
    public ListNode(int val) {
        this.val = val;
    }

    /*
     * methods
     */
    @Override
    public String toString() {
        return "{" + "val=" + val + "}";
    }
}
