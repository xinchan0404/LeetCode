package tencent.top10.pass2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-27
 */
public class Solution07 {

}

class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;

        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node !=null) {
            moveToHead(node);
            node.value = value;
        } else {
             node = new Node(key, value);
             map.put(key, node);
             addToHead(node);
             size++;
             if (size > capacity) {
                 int k = removeTail().key;
                 map.remove(k);
                 size--;
             }
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
        node.pre = head;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
}
