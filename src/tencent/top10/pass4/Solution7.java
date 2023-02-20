package tencent.top10.pass4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2023-02-18
 */
public class Solution7 {

}

class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (!map.containsKey(key)) {
            node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                map.remove(removeTail().key);
            }
        }
        node = map.get(key);
        node.value = value;
        moveToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
}
