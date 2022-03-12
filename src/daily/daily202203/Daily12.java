package daily.daily202203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-13
 */
public class Daily12 {
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
    }
    /**
     * 590. N 叉树的后序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postorder(root, list);
        return list;
    }

    private void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            postorder(root.children.get(i), list);
        }
        list.add(root.val);
    }

    /**
     * 590. N 叉树的后序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        return null;
    }
}
