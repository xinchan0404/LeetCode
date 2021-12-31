package codingInterviewDay.day02.randomLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2021-11-28
 */
public class CopyRandomList {
    public static void main(String[] args) {

    }

    /**
     * 复杂链表的复制 - 回溯、HashMap
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        return deepCopy(map, head);
    }

    /**
     * 深度拷贝递归方法
     *
     * @param map
     * @param head
     */
    private Node deepCopy(Map<Node, Node> map, Node head) {
        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }

        return map.get(head);
    }
}
