package crackingTheCodingInterview.ch16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-16
 */
public class Solution25 {
    /*
     * 面试题 16.25. LRU 缓存
     */
    class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public Solution25(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
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
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private int removeTail() {
        Node ans = tail.pre;
        removeNode(ans);
        return ans.key;
    }
}
