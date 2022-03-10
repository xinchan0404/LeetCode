package codingInterviewDay_2.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution03 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    private Map<Node, Node> map = new HashMap<>();
    /**
     * 剑指 Offer 35. 复杂链表的复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        while (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
