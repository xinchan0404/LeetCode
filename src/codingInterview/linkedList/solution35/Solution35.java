package codingInterview.linkedList.solution35;

import java.util.HashMap;

/**
 * @author xinchan
 * @version 1.0.1 2022-01-13
 */
public class Solution35 {
    private HashMap<Node, Node> map;
    /**
     * 剑指 Offer 35. 复杂链表的复制 - 递归、先完成 next 连接，再完成 random 连接
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            head.next = copyRandomList(head.next);
            head.random = copyRandomList(head.random);
        }

        return map.get(head);
    }
}
