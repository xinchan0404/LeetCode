package codingInterviewDay_2.day15;

import utils.Node;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-09
 */
public class Solution02 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,Node left,Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node head;
    private Node pre;
    /**
     * 剑指 Offer 36. 二叉搜索树与双向链表
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        inorder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        if (root.right != null) {
            inorder(root.right);
        }
    }
}
