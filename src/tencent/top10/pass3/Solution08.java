package tencent.top10.pass3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinchan
 * @version 1.0.1 2022-08-11
 */
public class Solution08 {
    class LRUCache {
        private Node head;
        private Node tail;
        private int capacity;
        private Map<Integer, Node> map;

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

        public LRUCache(int capacity) {
            // 初始化字段
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.capacity = capacity;
            this.map = new HashMap<>();

            // 初始化双端链表
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
                map.put(key, node);
                addToHead(node);
                if (map.size() > capacity) {
                    Node tail = removeTail();
                    map.remove(tail.key);
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next = node;
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

        private Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }
}
