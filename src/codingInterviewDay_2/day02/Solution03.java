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
     * 剑指 Offer 35. 复杂链表的复制 - 回溯 + HashMap
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

    /**
     * 剑指 Offer 35. 复杂链表的复制 - 迭代 + 节点拆分
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node copyNode = null;
        /*
         * 完成所有节点的拷贝和拷贝节点 next 指针的连接
         */
        for (Node node = head; node != null; node = node.next.next) {
            copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
        }
        /*
         * 完成所有拷贝节点 random 指针的连接
         */
        for (Node node = head; node != null; node = node.next.next) {
            copyNode = node.next;
            copyNode.random = (node.random != null) ? node.random.next : null;
        }
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            copyNode = node.next;
            node.next = node.next.next;
            copyNode.next = (node.next != null) ? node.next.next : null;
        }
        return newHead;
    }
}
