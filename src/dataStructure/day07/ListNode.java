package dataStructure.day07;

/**
 * @author xinchan
 * @version 1.0.1 2021-12-01
 */
public class ListNode {
    /*
     * instance field
     */
    int val;
    ListNode next;

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
        return "{" + "val=" + val + '}';
    }
}
