package daily.daily202203;

import java.util.*;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-10
 */
public class Daily10 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    /**
     * 589. N 叉树的前序遍历 - 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Map<Node, Integer> map = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                if (!cur.children.isEmpty()) {
                    map.put(cur, 0);
                    cur = cur.children.get(0);
                } else {
                    cur = null;
                }
            }
            cur = stack.peek();
            int index = map.getOrDefault(cur, -1) + 1;
            if (!cur.children.isEmpty() && index < cur.children.size()) {
                map.put(cur, index);
                cur = cur.children.get(index);
            } else {
                stack.pop();
                map.remove(cur);
                cur = null;
            }
        }
        return list;
    }
    /**
     * 589. N 叉树的前序遍历 - 迭代优化
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        return null;
    }
}
