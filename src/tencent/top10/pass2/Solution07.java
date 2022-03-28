package tencent.top10.pass2;

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

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        return;
    }
}
