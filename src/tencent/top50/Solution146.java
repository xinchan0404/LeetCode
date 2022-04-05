package tencent.top50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-04-05
 */
public class Solution146 {

}

class LRUCache {
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                map.remove(removeTail());
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private int removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node.key;
    }
}
