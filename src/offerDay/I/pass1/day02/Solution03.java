package offerDay.I.pass1.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * @author xinchan
 * @version 1.0.1 2022-￥06-24
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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}

class Solution03_ {
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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // next 节点
        for (Node node = head; node != null; node = node.next.next) {
            Node dump = new Node(node.val);
            dump.next = node.next;
            node.next = dump;
        }
        // random 节点
        for (Node node = head; node != null ; node = node.next.next) {
            node.next.random = node.random == null ? null : node.random.next;
        }
        // 断开原始节点和新建节点之间的连接
        Node newHead = head.next;
        Node cur = newHead;
        for (Node node = head; node != null; node = node.next) {
            node.next = node.next.next;
            cur.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;
        }
        return newHead;
    }
}
