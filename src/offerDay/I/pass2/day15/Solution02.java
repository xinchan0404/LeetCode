package offerDay.I.pass2.day15;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * @author xinchan
 * @version 1.0.1 2022-03-19
 */
public class Solution02 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
